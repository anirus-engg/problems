package com.ags.process;

import com.ags.model.CityConnection;
import java.util.HashSet;
import java.util.Set;

public class Connection {
  private Set<String> visitedCities = new HashSet<>();
  public String areConnected(String cityA, String cityB) {
    CityConnection cityConnection = CityConnection.getInstance();

    visitedCities.add(cityA);
    Set<String> connectedCities = cityConnection.getConnectedCities(cityA);
    for (String nextCity : connectedCities) {
      if (visitedCities.contains(nextCity)) {
        continue;
      }
      if (nextCity.equals(cityB)) {
        return "yes";
      }
      visitedCities.add(nextCity);
      String connected = areConnected(nextCity, cityB);
      if (connected.equals("yes")) {
        return "yes";
      }
    }
    return "no";
  }
}