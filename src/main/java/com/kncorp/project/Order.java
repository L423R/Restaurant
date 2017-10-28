package com.kncorp.project;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by L423R on 13.09.2017.
 */

@Stateful
public class Order implements Serializable {

    @Inject
    private DrinkEJB drinkEJB;
    @Inject
    private HookahEJB hookahEJB;
    @Inject
    private SaledEJB saledEJB;

    private List<String> list = new ArrayList<>();
    private Map<Integer,List<String>> map = new HashMap<>();

    private int sum = 0;
    private int count=1;

    private List<ALAH> alo = new ArrayList<>();


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


    //Сохранить каждый элемент заказа в бд
    public void saveSoldItems()
    {
        if (!list.isEmpty()){
            for (String s :list) {
                saledEJB.addSoldItem(new Saled(s.split(" ")[0]));
            }
        }

        list.clear();
        sum = 0;
        count++;
    }

    //Оставить заказ открытым
    public void leaveOpenOrder()
    {
        /*map.put(count,list);
        count++;*/
        alo.add(new ALAH(Integer.toString(count),list));
        list.clear();
        count++;

    }
    //получить заказ из карты по щелчку
    public void getOrderFromClick(int index)
    {
        ALAH alah = alo.get(index);
        list = alah.getList();
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
