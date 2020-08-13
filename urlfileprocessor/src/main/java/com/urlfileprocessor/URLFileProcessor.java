package com.urlfileprocessor;

import com.urlfileprocessor.process.FileProcessor;
import com.urlfileprocessor.process.Monitor;

public class URLFileProcessor {

  public static void main(String[] args) throws InterruptedException {

    if (args.length != 1) {
      System.out.println("Syntax: com.urlfileprocessor.URLFileProcessor directoryPath" );
      System.exit(1);
    }

    String directory = args[0];

    long start = System.currentTimeMillis();
    FileProcessor fileProcessor = new FileProcessor(directory);
    fileProcessor.readAllFiles();

    Thread.sleep(5000);
    int i = 1;
    while(!Monitor.getInstance().isProcessComplete()) {
      if (i == 6) {
        printSummary();
        i = 1;
      }
      Thread.sleep(5000);
      i++;
    }

    printSummary();

    System.out.println("Completed in : " + (System.currentTimeMillis() - start) + " millis");
  }

  private static void printSummary() {
    System.out.println("Successful: " + Monitor.getInstance().getSuccessfulAttempt());
    System.out.println("Failure: " + Monitor.getInstance().getFailureAttempt());
    System.out.println("Total: " + Monitor.getInstance().getTotalAttempt());
    System.out.println();
  }
}


