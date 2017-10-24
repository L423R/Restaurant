package com.kncorp.project;

import javax.persistence.*;

/**
 * Created by L423R on 09.09.2017.
 */
@Entity
@Table(name = "hookahs",schema = "kekjek")
@NamedQueries({
        @NamedQuery(name = "findHookahByName",query = "select h from Hookah h where h.name=:name"),
        @NamedQuery(name = "findAllHookahs",query = "select h from Hookah h")
})
public class Hookah extends Item {
    private String name;
    private int price;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hookah hookah = (Hookah) o;

        if (price != hookah.price) return false;
        if (name != null ? !name.equals(hookah.name) : hookah.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + price;
        return result;
    }
}
