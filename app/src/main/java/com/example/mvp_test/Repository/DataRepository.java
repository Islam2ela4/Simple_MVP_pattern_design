package com.example.mvp_test.Repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mvp_test.Model.DataModel;

public class DataRepository implements IDataRepository {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void storeData(Context context, String fname, String lname, String email){
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("F_name", fname);
        editor.putString("L_name", lname);
        editor.putString("Email", email);
        editor.commit();
    }

    @Override
    public void loadData(Context context, DataCallBack callBack){
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE);
        DataModel model = new DataModel();
        model.setFirst_name(sharedPreferences.getString("F_name", null));
        model.setLast_name(sharedPreferences.getString("L_name", null));
        model.setEmail(sharedPreferences.getString("Email", null));
        callBack.onCallBack(model);
    }


    public interface DataCallBack{
        void onCallBack(DataModel dataModel);
    }

}
