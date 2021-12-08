package com.example.lab5;

import android.app.Application;

import java.util.List;

public class MyRepository {
    private static List<ItemData> dataList;
    private static MyDao myDao;
    private static MyDB db;
    public MyRepository(Application context) {
        db = MyDB.getDatabase(context);
        myDao = db.myDao();
//dataList = myDao.getAllData(); // alternatively
    }
    public static List<ItemData> getDataList() {
        dataList = myDao.getAllData();
        return dataList;
    }
    void insertItem(ItemData item) {
        myDao.insert(item);
    }
    void deleteItem(ItemData item) {
        myDao.delete(item);
    }
}
