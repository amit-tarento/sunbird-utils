package org.sunbird.redis;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.sunbird.cache.interfaces.Cache;
import org.sunbird.common.models.util.LoggerEnum;
import org.sunbird.common.models.util.ProjectLogger;

public class RedisCache implements Cache {

  private static final String CACHE_MAP_LIST = "cache.mapNames";
  private Map<String, String> properties = readConfig();
  private String mapNameListStr = properties.get(CACHE_MAP_LIST);
  private String[] mapNameList = mapNameListStr.split(",");
  private RedissonClient client = null;

  public RedisCache() {
    client = RedisConnectionManager.getClient();
  }

  @Override
  public String get(String mapName, String key) {
    ProjectLogger.log("RedisCache:get: mapName = " + mapName + ", key = " + key, LoggerEnum.INFO.name());
    
    try {
      RMap<String, String> map = client.getMap(mapName);
      String s = map.get(key);
      return s;
    } catch (Exception e) {
      ProjectLogger.log("RedisCache:get: Error occurred mapName = " + mapName + ", key = " + key, LoggerEnum.ERROR.name());
    }
    return null;
  }

  @Override
  public boolean put(String mapName, String key, String value) {
    ProjectLogger.log("RedisCache:put: mapName = " + mapName + ", key = " + key + ", value = " + value, LoggerEnum.INFO.name());
    
    try {
      RMap<String, String> map = client.getMap(mapName);
      map.put(key, value);
      return true;
    } catch (Exception e) {
      ProjectLogger.log("RedisCache:put: Error occurred mapName = " + mapName + ", key = " + key + ", value = " + value, LoggerEnum.ERROR.name());
    }
    return false;
  }

  @Override
  public boolean clear(String mapName) {
    ProjectLogger.log("RedisCache:clear: mapName = " + mapName, LoggerEnum.INFO.name());

    try {
      RMap<String, String> map = client.getMap(mapName);
      map.clear();
      return true;
    } catch (Exception e) {
      ProjectLogger.log("RedisCache:clear: Error occurred mapName = " + mapName + " error = " + e, LoggerEnum.ERROR.name());
    }
    return false;
  }

  @Override
  public void clearAll() {
    ProjectLogger.log("RedisCache: clearAll called", LoggerEnum.INFO.name());

    for (int i = 0; i < mapNameList.length; i++) {
      clear(mapNameList[i]);
    }
  }

  @Override
  public boolean setMapExpiry(String name, long seconds) {
    boolean result = client.getMap(name).expire(seconds, TimeUnit.SECONDS);
    
    ProjectLogger.log("RedisCache:setMapExpiry: name = " + name + " seconds = " + seconds + " result = " + result, LoggerEnum.INFO.name());

    return result;
  }
}
