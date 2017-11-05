package com.kncorp.project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by L423R on 25.10.2017.
 */
@Stateless
public class SoldEJB implements Serializable{

    public static final String FIND_SOLD_BY_NAME ="findSoldByName";

    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public List<Sold> findSoldByName(String name){
        TypedQuery<Sold> query = em.createNamedQuery("findSoldByName", Sold.class);
        query.setParameter("name",name);

        List<Sold> list = query.getResultList();

        return list;
    }

    public void addSoldItem(Sold sold)
    {
        em.persist(sold);
    }

    public List<Object[]> moneyForMonth(){
        String query = "select s.nameItem, count(s.id) as c from Sold s where (FUNC('MONTH', s.time)=FUNC('MONTH', current_timestamp)) group by s.nameItem";
        TypedQuery<Object[]> query12 = em.createQuery(query, Object[].class);
        return query12.getResultList();
    }
}
