package com.kncorp.project;

import java.util.ArrayList;
import java.util.List;

public class ALAH {
    private String number;
    private List<String> list = new ArrayList<>();

    public ALAH(String number, List<String> list) {
        this.number = number;
        this.list = list;
    }

    public ALAH() {
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
        this.list = list;
    }
}
