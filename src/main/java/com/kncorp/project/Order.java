package com.kncorp.project;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by L423R on 13.09.2017.
 */

@Stateful
public class Order implements Serializable {

    @Inject
    private DrinkEJB drinkEJB;
    @Inject
    private HookahEJB hookahEJB;

    private List<String> list = new ArrayList<>();

    private int sum = 0;


    public void addIntoList(String s)
    {
        String[] split = s.split(":");
        if (split.length!=2) return;
        // list = order.getList();
        // System.out.println(list.size()+" gggggggggggggggggggggggggggggggggggggggggggggg");
        switch (split[0]) {
            case "hookah":
                Hookah hookah = hookahEJB.findHookahByName(split[1]);
                list.add(hookah.getName());
                sum += hookah.getPrice();
                break;
            case "drink":
                Drink drink = drinkEJB.findDrinkByName(split[1]);
                list.add(drink.getName()+" "+drink.getPrice());
                sum += drink.getPrice();
                break;
        }
        System.out.println(list.size()+"SASIMOYasdasdasdasd");
    }


    public List getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public int getSum() {
        return sum;
    }
}
