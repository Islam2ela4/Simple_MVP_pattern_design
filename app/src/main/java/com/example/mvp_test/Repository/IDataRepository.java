package com.example.mvp_test.Repository;

import android.content.Context;

import com.example.mvp_test.Repository.DataRepository;

public interface IDataRepository {
    void storeData(Context context, String fname, String lname, String email);

    void loadData(Context context, DataRepository.DataCallBack callBack);
}
