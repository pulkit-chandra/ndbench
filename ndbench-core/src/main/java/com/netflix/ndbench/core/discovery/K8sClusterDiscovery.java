package com.netflix.ndbench.core.discovery;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Pulkit Chandra
 */
public class K8sClusterDiscovery implements IClusterDiscovery {
  private static final Logger logger = LoggerFactory.getLogger(K8sClusterDiscovery.class.getName());
  @Override
  public List<String> getApps() {
    return Arrays.<String>asList(getLocalhostName());
  }

  private String getLocalhostName() {
    String serviceHost = "ndbench.tgf.pcf-gemfire.com";
    logger.info("Setting Service Host as " + serviceHost);
//    if (Strings.isNullOrEmpty(serviceHost)){
//      serviceHost = System.getenv("HOSTNAME");
//      logger.warn("Skipping Service Port now falling back to HOSTNAME " + serviceHost);
//    }
    return serviceHost;
  }

  @Override
  public List<String> getEndpoints(String appName, int defaultPort)
  {
    return Arrays.asList(getLocalhostName() + ":" + defaultPort);
  }
}
