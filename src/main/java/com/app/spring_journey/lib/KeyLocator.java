package com.app.spring_journey.lib;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.LocatorAdapter;
import io.jsonwebtoken.ProtectedHeader;

@Component
public class KeyLocator extends LocatorAdapter<Key>{

  Map<String, Key> keyStore = new HashMap<>();

  public void addKey(String keyId, Key key) {
    keyStore.put(keyId, key);
  }
  
  @Override
  protected Key locate(ProtectedHeader header) {
    String keyId = header.getKeyId();
    Key key = keyStore.get(keyId);
    return key;
  }
  
}
