package com.boatrain.map;

import java.util.HashMap;

/*
https://leetcode.cn/problems/design-authentication-manager/
* */
class AuthenticationManager {
    private int ttl;
    private HashMap<String, Integer> map = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        Integer bornTime = map.get(tokenId);
        if (bornTime == null) {
            return;
        }
        if (currentTime - bornTime >= ttl) {
            map.remove(tokenId);
            return;
        }
        map.put(tokenId, currentTime);
    }

    public int countUnexpiredTokens(int currentTime) {
//        System.out.println("current map:" + map);
        return (int) map.values().stream().filter(bornTime -> bornTime + ttl > currentTime).count();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */