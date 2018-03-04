package com.zf.springboot.firstapp.repository;

import com.zf.springboot.firstapp.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/3/4.
 */
@Repository
public class UserRepository {

    private final static ConcurrentMap<Integer, User> userConcurrentMap = new ConcurrentHashMap<>();

    private final static AtomicInteger atomicInteger = new AtomicInteger();

    public synchronized boolean save(User user) {
        user.setId(atomicInteger.incrementAndGet());
        return userConcurrentMap.put(user.getId(), user)==null;
    }
    public Collection<User> findAll(){
        return userConcurrentMap.values();
    }

}
