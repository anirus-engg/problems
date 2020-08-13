package com.urlfileprocessor.process;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class FileProcessor {
  private static final int CPU = 4;
  private final String directory;

  public FileProcessor(String directory) {
    this.directory = directory;
  }

  public void readAllFiles() {
    ExecutorService service = Executors.newFixedThreadPool(CPU);
    try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
      paths.filter(Files::isRegularFile).forEach(f -> service.submit(new FileReadThread(f)));
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    service.shutdown();
  }
}
