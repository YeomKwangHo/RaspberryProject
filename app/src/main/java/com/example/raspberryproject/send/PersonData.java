package com.example.raspberryproject.send;

/**
 * Created by SaBaRaDa on 2016-01-03.
 */
public class PersonData {

    private int age;
    private String name;
    private boolean sex;

    public void setPerson(String name, int age, boolean sex)
    {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getPerson()
    {
        return name + " " + age + " " + sex;
    }
}
