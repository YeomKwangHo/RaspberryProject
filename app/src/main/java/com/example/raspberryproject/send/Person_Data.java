package com.example.raspberryproject.send;

/**
 * Created by SaBaRaDa on 2016-01-03.
 */
public class Person_Data {
    String mpersonName;
    int mpersonAge;
    boolean mpersonSex;

    public void setPerson(String name, int age, boolean sex)
    {
        mpersonName = name;
        mpersonAge = age;
        mpersonSex = sex;
    }

    public String getPerson()
    {
        return mpersonName + " " + mpersonAge + " " + mpersonSex;
    }
}
