package com.kncorp.project;

import javax.ejb.Stateful;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
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
    private ALAH alah;
    private List<String> list = new ArrayList<>();
    private Map<Integer,List<String>> map = new HashMap<>();

    private int sum = 0;
    private int count=10;
    public static int id=0;

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

        if (alah!=null)
            if (alo.contains(alah)) {
                alo.remove(alah);
                alah = null;
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
        if (alah ==null) {
            alah = new ALAH(Integer.toString(count), sum, list,alo.size());
            alo.add(alah);
            System.out.println(list.size() + "   -----------   first size " + alo.get(0));
            System.out.println(list.size() + "   -----------   first size " + alo.get(0));
            count++;

        }else
        {
            System.out.println(list.size() + "   -----------   first size " + alo.get(0));
            alah.setList(list);
            alah.setSum(sum);
            if (!alo.contains(alah) && alo.size()<9) {
                alah.setNumber(Integer.toString(count));
                alah.setSize(alo.size());
                alo.add(alah);

            }
            System.out.println(list.size() + "   -----------   first size " + alo.get(0));

        }
        alah = null;
        list.clear();
        System.out.println(list.size() + "   -----------   first size " + alo.get(0));
        sum = 0;

    }
    //получить заказ из карты по щелчку
    public void reloadOrder(int id)
    {
        /*int n = Integer.parseInt(id);*/
        if (alo.size()>id) {
            alah = alo.get(id);
            list.clear();
            list.addAll(alah.getList());
            System.out.println(list.size() + "   -----------   alh size " + alah);
            sum = alah.getSum();
        }
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



}
