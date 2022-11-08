package com.nhnacademy.domain;

import java.time.LocalDateTime;
import lombok.Value;

@Value
public class Post {

    private final String title;
    private final String content;
    private final String id;
    private final LocalDateTime writerTime;
    private final int viewCount;
}
