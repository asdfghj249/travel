package com.pojo;

public class FavoriteKey {
    private Integer rid;

    private Integer uid;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "FavoriteKey{" +
                "rid=" + rid +
                ", uid=" + uid +
                '}';
    }
}