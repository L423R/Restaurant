package com.kncorp.project;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class AdminController implements Serializable {

    public static final String QUERY_GET_MONEY_FOR_MONTH ="Отчет о продажах за месяц";
    private int sum;
    private List<String> list = new ArrayList<>();

    @Inject
    private SoldEJB soldEJB;
    @Inject
    private DrinkEJB drinkEJB;
    @Inject
    private HookahEJB hookahEJB;

    public void calcMoneyForCurrentMonth()
    {
        List<Drink> allDrinks = drinkEJB.findAllDrinks();
        List<Hookah> allHookahs = hookahEJB.findAllHookahs();
        sum=0;
        List<Object[]> resultList = soldEJB.moneyForMonth();
        for (Object[] objects:resultList)
        {
            System.out.println(objects[0]+" objects[0] "+objects[0].getClass());
            System.out.println(objects[1]+" objects[1] "+objects[1].getClass());
            System.out.println("________________________");

            String s = (String) objects[0];
            long x = (long) objects[1];
            /*for (int i = 0; i < allDrinks.size(); i++) {
                if (allDrinks.get(i).getName().equals(s))
                    sum+=allDrinks.get(i).getPrice()*x;
            }
            for (int i = 0; i < allHookahs.size(); i++) {
                if (allHookahs.get(i).getName().equals(s))
                    sum+=allHookahs.get(i).getPrice()*x;
            }*/

            method1(allDrinks,s,x);
            method1(allHookahs,s,x);
            list.add(s+"  -  "+Integer.toString((int)x));
        }
        System.out.println(sum+" summAA||||||||||||||||||||");
    }

    private void method1(List<? extends Item> list,String s,long x)
    {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(s))
                sum+=list.get(i).getPrice()*x;
        }
    }

    public SoldEJB getSoldEJB() {
        return soldEJB;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
