package com.kncorp.project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;

@Stateless
public class UserEJB implements Serializable {
    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public User findUserByLogin(String login)
    {
        TypedQuery<User> query = em.createNamedQuery("findUserByLogin",User.class);
        query.setParameter("login", login);
        User user = null;

        try{
            user = query.getSingleResult();
        }catch (Exception e){

        }
        return user;
    }
}
