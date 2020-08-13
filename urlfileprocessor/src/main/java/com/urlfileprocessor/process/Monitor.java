package com.urlfileprocessor.process;

import java.util.HashMap;
import java.util.Map;

public class Monitor {
  private static Monitor instance;
  private long successfulAttempt = 0;
  private long failureAttempt = 0;
  private Map<String, Boolean> fileReadMonitorMap = new HashMap<>();

  // Can be used to track the URLs that failed
  // private List<UrlConnectionAttempt> failedAttempts = new ArrayList<>();

  private Monitor(){}

  public static Monitor getInstance() {
    if (instance == null) {
      instance = new Monitor();
    }
    return instance;
  }

  public void putFileReadMonitor(String fileReadServiceId, Boolean value) {
    fileReadMonitorMap.put(fileReadServiceId, value);
  }

  public boolean isProcessComplete() {
    boolean retVal = true;
    for (String key : fileReadMonitorMap.keySet()) {
      retVal = retVal && fileReadMonitorMap.get(key);
    }
    return retVal;
  }

  public void addSuccessfulAttempt() {
    successfulAttempt++;
  }

  public long getSuccessfulAttempt() {
    return successfulAttempt;
  }

  public long getFailureAttempt() {
    return failureAttempt;
  }

  public void addFailureAttempt() {
    failureAttempt++;
  }

  public long getTotalAttempt() {
    return successfulAttempt + failureAttempt;
  }

  /*public void add(UrlConnectionAttempt attempt) {
    failedAttempts.add(attempt);
  }

  public List<UrlConnectionAttempt> getFailedAttempts() {
    return failedAttempts;
  }*/
}
