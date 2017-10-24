package com.kncorp.project;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by L423R on 11.09.2017.
 */
@Named
@RequestScoped
public class MainController {
    @Inject
    private DrinkEJB drinkEJB;
    @Inject
    private HookahEJB hookahEJB;

    private String item = "hookah";

    private List<String> list = new ArrayList<>();

    public List getMenuList()
    {
        if (item==null) return null;
        switch (item){
            case "drink":
               return drinkEJB.findAllDrinks();
            case "hookah":
               return  hookahEJB.findAllHookahs();
            default:return null;
        }

    }

   /* public void addItemIntoMenu(String param)
    {

        String[] split = param.split(":");
        if (split.length!=2) return;
       // list = order.getList();
       // System.out.println(list.size()+" gggggggggggggggggggggggggggggggggggggggggggggg");
        switch (split[0]) {
            case "hookah":
                order.addIntoList(hookahEJB.findHookahByName(split[1]).getName());
                break;
            case "drink":
                order.addIntoList(drinkEJB.findDrinkByName(split[1]).getName());
                break;
        }
        System.out.println(order.getList().size()+"SASIMOYasdasdasdasd");
       // order.setList(list);

    }*/

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
