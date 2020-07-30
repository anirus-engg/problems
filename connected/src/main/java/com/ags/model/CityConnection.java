package com.ags.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CityConnection {

  private static final CityConnection INSTANCE = new CityConnection();
  private Map<String, Set<String>> cityConnectionMap = new HashMap<>();

  private CityConnection() {};

  public static CityConnection getInstance() {
    return INSTANCE;
  }

  public void addCityConnection(String cityA, String cityB) {
    Set<String> connectedCities = cityConnectionMap.computeIfAbsent(cityA, k -> new HashSet<>());
    connectedCities.add(cityB);
    cityConnectionMap.put(cityA, connectedCities);

    connectedCities = cityConnectionMap.computeIfAbsent(cityB, k -> new HashSet<>());
    connectedCities.add(cityA);
    cityConnectionMap.put(cityB, connectedCities);
  }

  public Set<String> getConnectedCities(String city) {
    return cityConnectionMap.computeIfAbsent(city, k -> new HashSet<>());
  }
}