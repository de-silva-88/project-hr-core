package com.hr.data.cache;

import lombok.extern.slf4j.Slf4j;
import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;

@Slf4j
public class ApplicationCacheFactory {

    private static Cache<String, Object> cache;

    public static Cache<String, Object> getCache() {
        if (cache == null) {
            log.info("Cache is not created yet. Initializing cache...");
            CacheManagement.initCache();
        }
        return cache;
    }

    private static class CacheManagement {

        private static void initCache() {
            cache = new DefaultCacheManager().getCache();
        }
    }
}
