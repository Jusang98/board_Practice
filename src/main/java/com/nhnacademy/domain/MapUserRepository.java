package com.nhnacademy.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUserRepository implements UserRepository{
    private Map<String,User> map = new HashMap<>(5);
    private List<User> users = new ArrayList<>();
    @Override
    public void addUser(User user) {
        map.put(user.getId(),user);
        users.add(user);
    }
    //수정
    @Override
    public void modify(User user) {
        map.put(user.getId(),user);
    }

    @Override
    public User remove(String id) {
        return map.remove(id);
    }

    @Override
    public User getUser(String id) {
        return map.get(id);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }


}
