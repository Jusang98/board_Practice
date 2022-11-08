package com.nhnacademy.domain;


import lombok.Value;

@Value
public class User  {
    private final String id;
    private final String pwd;
    private final String name;


}
