package org.example;

public class Office {
    private int officecode;
    private String city, state;

    public Office(int officecode, String city, String state) {
        this.officecode = officecode;
        this.city = city;
        this.state = state;
    }

    public int getOfficecode() {
        return officecode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Office{" +
                "officecode=" + officecode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
