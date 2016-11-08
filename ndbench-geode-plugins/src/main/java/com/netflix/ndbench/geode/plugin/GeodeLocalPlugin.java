package com.netflix.ndbench.geode.plugin;

import com.google.inject.Singleton;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.netflix.ndbench.api.plugin.DataGenerator;
import com.netflix.ndbench.api.plugin.NdBenchClient;
import com.netflix.ndbench.api.plugin.annotations.NdBenchClientPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a Geode plugin which assumes that Geode processes
 * are running on the localhost.
 *
 * Locator process is running on localhost and port is *55221*
 * @author Pulkit Chandra
 *
 */

@Singleton
@NdBenchClientPlugin("GeodeLocalhostClient")
//@Import(SpringDataGeodeConfiguration.class)
@SuppressWarnings("unused")
public class GeodeLocalPlugin implements NdBenchClient{

  private final static Logger LOGGER = LoggerFactory.getLogger(GeodeLocalPlugin.class);

  private DataGenerator dataGenerator;

//  @Autowired
  private ClientCache clientCache;

//  @Autowired
  private Region<Object, Object> sampleRegion;

  public void init(final DataGenerator dataGenerator) throws Exception {
    this.dataGenerator = dataGenerator;
    LOGGER.info("Initializing Geode Region");
    clientCache = new ClientCacheFactory()
        .addPoolLocator("10.0.0.138",55221)
        .create();
    sampleRegion =
        clientCache.createClientRegionFactory(ClientRegionShortcut.PROXY).create("Sample");
  }

  public String readSingle(final String key) throws Exception {
    return null;
  }

  public String writeSingle(final String key) throws Exception {
    return null;
  }

  public void shutdown() throws Exception {

  }

  public String getConnectionInfo() throws Exception {
    return null;
  }

  public String runWorkFlow() throws Exception {
    return null;
  }
}
