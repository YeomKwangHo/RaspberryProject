package com.example.raspberryproject.receive.info;

/**
 * Created by ��ȣ on 2015-12-11.
 */
public class ReceivePersonData {

    int id;
    int personAge;
    String personName;
    boolean personSex;

    public void setPerson(int id, String name, int age, boolean sex)
    {
        this.id = id;
        this.personName = name;
        this.personAge = age;
        this.personSex = sex;
    }

    public String getPerson()
    {
        return this.personName + " " + this.personAge + " " + this.personSex;
    }
}
