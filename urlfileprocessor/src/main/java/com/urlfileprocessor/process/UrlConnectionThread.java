package com.urlfileprocessor.process;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UrlConnectionThread implements Runnable{

  private static Lock lock = new ReentrantLock();

  private final String url;
  private final String charset = "UTF-8";

  public UrlConnectionThread(String url) {
    this.url = url;
  }

  @Override
  public void run() {
    HttpURLConnection connection = null;
    try {
      connection = (HttpURLConnection) new URL(url).openConnection();
      connection.setRequestMethod("GET");
      connection.connect();
      if (! (connection.getResponseCode() == HttpURLConnection.HTTP_OK)) {
        lock.lock();
        // Track the URLs that failed
        //Monitor.getInstance().add(new UrlConnectionAttempt(url, connection.getResponseMessage()));
        Monitor.getInstance().addFailureAttempt();
        lock.unlock();
      } else {
        Monitor.getInstance().addSuccessfulAttempt();
        //System.out.println("[Success] " + url + " - Response: " + connection.getResponseMessage
        // ());
      }
    } catch (IOException ie) {
      lock.lock();
      Monitor.getInstance().addFailureAttempt();
      // Track the URLs that failed
      // Monitor.getInstance().add(new UrlConnectionAttempt(url, ie.getMessage()));
      lock.unlock();

      ie.printStackTrace();
    } finally {
      if (connection != null) {
        connection.disconnect();
      }
    }
  }
}
