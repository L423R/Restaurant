package com.kncorp.project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by L423R on 25.10.2017.
 */
@Stateless
public class SaledEJB {
    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public List<Saled> findSoldByName(String name){
        TypedQuery<Saled> query = em.createNamedQuery("findSoldByName", Saled.class);
        query.setParameter("name",name);

        List<Saled> list = query.getResultList();

        return list;
    }

    public void addSoldItem(Saled saled)
    {
        em.persist(saled);
    }
}
