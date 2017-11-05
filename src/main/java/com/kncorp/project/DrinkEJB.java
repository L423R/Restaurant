package com.kncorp.project;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by L423R on 09.09.2017.
 */
@Named
@Stateless
public class DrinkEJB implements Serializable {
    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public Drink findDrinkByName(String name)
    {
        TypedQuery<Drink> query = em.createNamedQuery("findDrinkByName", Drink.class);
        query.setParameter("name",name);
        Drink drink = null;

        try {
            drink = query.getSingleResult();
        }catch (Exception e)
        {

        }
        return drink;
    }

    public List<Drink> findAllDrinks()
    {
        TypedQuery<Drink> query = em.createNamedQuery("findAllDrinks", Drink.class);
        return query.getResultList();
    }
}
