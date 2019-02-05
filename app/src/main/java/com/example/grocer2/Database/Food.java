package com.example.grocer2.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "food_table")
public class Food {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "upc")
    private int upc;

    @ColumnInfo(name = "name")
    private String name;

    public Food(String name, int upc) {
        this.name = name;
        this.upc = upc;
    }

    public int getFood() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUpc() {
        return upc;
    }
}
