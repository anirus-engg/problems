package com.ags;

import com.ags.process.Connection;
import com.ags.process.LoadFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Connected {

  public static void main(String[] args) {
    // validate arguments
    if (args.length != 3) {
      System.out.println("Correct arguments not supplied");
      System.out.println("Expected arguments: filename cityname1 cityname2");
      System.exit(1);
    }

    String filename = args[0];
    if (Files.notExists(Paths.get(filename))) {
      System.out.println("Supplied data file does exist.  Please check and try again.");
      System.exit(1);
    }

    String cityName1 = args[1];
    String cityName2 = args[2];

    Connected connected = new Connected();
    System.out.println(connected.run(filename, cityName1, cityName2));
  }

  private String run(String file, String cityA, String cityB) {
    LoadFile loadFile = new LoadFile();
    try {
      loadFile.processFile(file);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    Connection connection = new Connection();
    return connection.areConnected(cityA, cityB);
  }
}
