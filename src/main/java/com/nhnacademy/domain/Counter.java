package com.nhnacademy.domain;

public class Counter {
    int count;
    public Counter(){
        count=0;
    }
    public int getCount(){
        return count;
    }
    public void setCount(){
        count = count+1;
    }
}
