package com.urlfileprocessor.process;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class FileReadThread implements Runnable {
  private final Path filePath;

  public FileReadThread(Path filePath) {
    this.filePath = filePath;
  }

  @Override
  public void run() {
    Stream<String> lines = Stream.empty();
    try {
      lines = Files.lines(filePath);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    long id = System.currentTimeMillis();
    ExecutorService service = Executors.newFixedThreadPool(32); // after testing
    Monitor.getInstance().putFileReadMonitor(id + "", false);
    lines.forEach(l -> service.submit(new UrlConnectionThread(l)));
    service.shutdown();

    try {
      if(service.awaitTermination(10, TimeUnit.MINUTES)) {
        // System.out.println("File read terminated for " + service);
        Monitor.getInstance().putFileReadMonitor(id + "", true);
      }
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    }
  }
}
