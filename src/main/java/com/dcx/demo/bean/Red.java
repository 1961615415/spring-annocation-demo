package com.dcx.demo.bean;

public class Red {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "red";
    }
    public Red(){
        System.out.println("初始化Red");
    }
}
