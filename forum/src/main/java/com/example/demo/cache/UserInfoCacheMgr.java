package com.example.demo.cache;

import com.example.demo.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : hongbo
 * @create 2021-12-14-15:48
 **/
public enum UserInfoCacheMgr {
    INSTANCE;

    private static Map<Long, User> userId2UserCacheMgr = new HashMap<>();

    public static User getUserByUserId(Long userId)
    {
        return userId2UserCacheMgr.get(userId);
    }

    public static void setUserId2User(Long userId,User user)
    {
        userId2UserCacheMgr.put(userId, user);
    }

    public static void clearCache()
    {
        userId2UserCacheMgr.clear();
    }
}
