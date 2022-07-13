package com.company.monthandmathservice.models;

import java.util.Objects;

public class MonthsConverter {
    private int number;
    private String name;

    public int getNumber() {
        return number;
    }

    public  void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public MonthsConverter(int number) {
        this.number = number;
    }

    public MonthsConverter() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthsConverter that = (MonthsConverter) o;
        return number == that.number && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }

    @Override
    public String toString() {
        return "MonthsConverter{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    public MonthsConverter(int number, String name) {
        this.number = number;
        this.name = name;
    }


}
