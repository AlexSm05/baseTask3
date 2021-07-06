package com.company;

import java.util.ArrayList;

public class Human implements Comparable<Human>{
    public String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human saveInArray(String next){
        Human h = new Human();
        String[] subStr=next.split("\\s");
        h.setName(subStr[0]);
        h.setAge(Integer.parseInt(subStr[1]));
        return h;

    }

    @Override
    public int compareTo(Human anotherHuman) {
        if (this.age==anotherHuman.age){
        return 0;
        }else if(this.age<anotherHuman.age) {
            return -1;
        }else {
            return 1;
        }

    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
