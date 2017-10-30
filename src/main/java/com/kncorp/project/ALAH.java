package com.kncorp.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ALAH {
    private String number;
    private int sum;
    private List<String> list = new ArrayList<>();
    private int size;

    public ALAH(String number, int sum, List<String> list, int size) {
        this.number = number;
        this.sum = sum;
       // this.list = list;
        this.list.addAll(list);
        this.size = size;
        generateCode();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        generateCode();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list.clear();
        this.list.addAll(list);
    }



    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    private void generateCode()
    {
        number = Integer.toString(size)+"_"+number;
    }

    @Override
    public String toString() {
        return "ALAH{" +
                "number='" + number + '\'' +
                ", sum=" + sum +
                ", list=" + list +
                ", class=" + this.hashCode() +
                '}';
    }
}
