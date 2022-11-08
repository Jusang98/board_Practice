package com.nhnacademy.domain;

import java.util.List;

public interface PostRepository {
    void register(Post post);
    void modify(Post post);
    Post remove(String id);

    Post getPost(String id);
    List<Post> getPosts();
}
