package com.pojo;

import java.util.Date;

public class Favorite extends FavoriteKey {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "date=" + date +
                '}';
    }
}