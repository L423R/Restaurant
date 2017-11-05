package com.kncorp.project;

import javax.persistence.*;
import java.sql.Timestamp;



/**
 * Created by L423R on 25.10.2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = SoldEJB.FIND_SOLD_BY_NAME,query = "select s from Sold s where s.nameItem=:name"),
        @NamedQuery(name = "4len",query = "select s.nameItem, count(s.id) as c from Sold s where (FUNC('MONTH', s.time)=FUNC('MONTH', current_timestamp ))")
})
@Table(name = "saled")
public class Sold {



    private int id;
    private String nameItem;
    private Timestamp time;

    public Sold() {
    }

    public Sold(String nameItem) {
        this.nameItem = nameItem;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_item")
    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sold sold = (Sold) o;

        if (id != sold.id) return false;
        if (nameItem != null ? !nameItem.equals(sold.nameItem) : sold.nameItem != null) return false;
        if (time != null ? !time.equals(sold.time) : sold.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameItem != null ? nameItem.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
