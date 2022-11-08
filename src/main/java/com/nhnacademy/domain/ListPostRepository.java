package com.nhnacademy.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListPostRepository implements PostRepository  {
    private List<Post> Posts = new ArrayList<>();
    private Map<String,Post> map = new HashMap<>();
    @Override
    public void register(Post post) {
        map.put(post.getId(),post);
        Posts.add(post);
    }

    @Override
    public void modify(Post post) {
        map.put(post.getId(),post);
    }

    @Override
    public Post remove(String id) {
        return map.remove(id);
    }

    @Override
    public Post getPost(String id) {
        return map.get(id);
    }

    @Override
    public List<Post> getPosts() {
        return Posts;
    }
}
