package com.ags.process;

import com.ags.model.CityConnection;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LoadFile {

  public void processFile(String file) throws IOException {
    Stream<String> lines = Files.lines(Paths.get(file), StandardCharsets.UTF_8);
    lines.forEach(this::processLine);
  }

  private void processLine(String line) {
    String[] city = line.split(",");
    for (int i = 0; i < city.length; i++) {
      for (int j = i + 1; j < city.length; j++) {
        CityConnection.getInstance().addCityConnection(city[i].trim(), city[j].trim());
      }
    }
  }
}
