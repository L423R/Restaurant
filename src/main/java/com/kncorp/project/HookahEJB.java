package com.kncorp.project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by L423R on 09.09.2017.
 */
@Stateless
public class HookahEJB {
    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public Hookah findHookahByName(String name)
    {
        TypedQuery<Hookah> query = em.createNamedQuery("findHookahByName", Hookah.class);
        query.setParameter("name", name);

        Hookah hookah = null;

        try {
            hookah = query.getSingleResult();
        }catch (Exception e)
        {

        }
        return hookah;
    }

    public List<Hookah> findAllHookahs()
    {
        TypedQuery<Hookah> query = em.createNamedQuery("findAllHookahs", Hookah.class);
        return  query.getResultList();
    }
}
