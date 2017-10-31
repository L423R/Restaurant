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
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getNumber() {
        return Integer.toString(size)+"_"+number;
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

    /*private String generateCode()
    {
        return Integer.toString(size)+"_"+number;
    }*/

    @Override
    public String toString() {
        return "ALAH{" +
                "number='" + number + '\'' +
                ", sum=" + sum +
                ", list=" + list +
                ", stol=" + size +
                ", class=" + this.hashCode() +
                '}';
    }
}
