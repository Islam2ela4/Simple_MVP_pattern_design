package com.example.mvp_test.Presenter;

import android.content.Context;

import com.example.mvp_test.Repository.DataRepository;
import com.example.mvp_test.Model.DataModel;
import com.example.mvp_test.Repository.IDataRepository;
import com.example.mvp_test.View.IMainView;

public class DataPresenter implements IDataPresenter {

    IDataRepository dataRepository = new DataRepository();

    @Override
    public void onButtonClickStoreData(IMainView mainView, String fname, String lname, String email){
        dataRepository.storeData((Context) mainView, fname, lname, email);
    }

    @Override
    public void onButtonClickLoadData(final IMainView mainView){
        dataRepository.loadData((Context) mainView, new DataRepository.DataCallBack() {
            @Override
            public void onCallBack(DataModel dataModel) {
                mainView.setAll(dataModel.getFirst_name(), dataModel.getLast_name(), dataModel.getEmail());
            }
        });
    }
}
