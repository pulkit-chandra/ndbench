package com.netflix.ndbench.core.discovery;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pulkit Chandra
 */
public class K8sClusterDiscovery implements IClusterDiscovery {
  @Override
  public List<String> getApps() {
    return Arrays.asList(getLocalhostName());
  }

  private String getLocalhostName() {
    return Inet4Address.getLoopbackAddress().getHostAddress();
  }

  @Override
  public List<String> getEndpoints(String appName, int defaultPort)
  {
    return Arrays.asList(getLocalhostName() + ":" + defaultPort);
  }
}
