package com.kncorp.project;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by L423R on 13.09.2017.
 */

@Stateful
public class OrderEJB implements Serializable {

    @Inject
    private DrinkEJB drinkEJB;
    @Inject
    private HookahEJB hookahEJB;
    @Inject
    private SoldEJB soldEJB;
    private Order order;
    private List<String> list = new ArrayList<>();

    private int sum = 0;
    private int count=10;
    public static int id=0;
    private int stol = 0;

    private List<Order> alo = new ArrayList<>();


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
                soldEJB.addSoldItem(new Sold(s.split(" ")[0]));
            }
        }

        if (order !=null)
            if (alo.contains(order)) {
                alo.remove(order);
                order = null;
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
        if (order ==null) {
            order = new Order(Integer.toString(count), sum, list,stol);
            alo.add(order);
            System.out.println(list.size() + "   -----------   first size " + alo.get(0)+" SMOKE "+stol);
            count++;

        }else
        {
            System.out.println(list.size() + "   -----------   first size " + alo.get(0));
            order.setList(list);
            order.setSum(sum);
            order.setSize(stol);

            System.out.println(list.size() + "   -----------   first size " + alo.get(0));

        }
        order = null;
        list.clear();
        System.out.println(list.size() + "   -----------   first size " + alo.get(0));
        sum = 0;
        stol = 0;

    }
    //получить заказ из карты по щелчку
    public void reloadOrder(int id)
    {
        /*int n = Integer.parseInt(id);*/
        if (alo.size()>id) {
            order = alo.get(id);
            list.clear();
            list.addAll(order.getList());
            System.out.println(list.size() + "   -----------   alh size " + order +" "+ stol);
            sum = order.getSum();
            stol = order.getSize();
        }
    }

    public int getStol() {
        return stol;
    }

    public void setStol(int stol) {
        this.stol = stol;
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


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String setTextFroButton(String num)
    {
        int n = Integer.parseInt(num);
        if (alo.isEmpty() || n >= alo.size())
        {
            return num;
        }else return alo.get(n).getNumber();  /*return "1";*/


    }


    public int ddIndex()
    {
        return alo.size();
    }
}
