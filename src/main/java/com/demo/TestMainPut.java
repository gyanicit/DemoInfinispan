package com.demo;

import java.io.IOException;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;

public class TestMainPut {

	public static void main(String[] args) throws IOException {
		// Create a configuration for a locally-running server
	      ConfigurationBuilder builder = new ConfigurationBuilder();
	      builder.addServer().host("127.0.0.1").port(ConfigurationProperties.DEFAULT_HOTROD_PORT);
	      // Connect to the server
	      RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build());
	      // Obtain the remote cache
	      RemoteCache<String, String> cache = cacheManager.getCache();
	      /// Store a value
	      //cache.put("name", "Gyan");
	      // Retrieve the value and print it out
	      System.out.printf("key = %s\n", cache.get("name"));
	      // Stop the cache manager and release all resources
	      cacheManager.close();
	      cacheManager.stop();
	}

}
