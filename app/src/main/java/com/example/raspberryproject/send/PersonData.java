package com.example.raspberryproject.send;

/**
 * Created by SaBaRaDa on 2016-01-03.
 */
public class PersonData {

    int mpersonAge;
    String mpersonName;
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
