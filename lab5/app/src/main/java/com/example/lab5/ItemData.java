package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item_table")
    public class ItemData {
        @PrimaryKey(autoGenerate = true)
        @NonNull
        public int id;
        @ColumnInfo(name = "text_main")
        public String txtMain;
        @ColumnInfo(name = "text_2")
        public String txtSecond;
        @ColumnInfo(name = "rating")
        public int rating;
        @ColumnInfo(name = "age")
        public int age;
        @ColumnInfo(name = "sex")
        public boolean gender;
    }

