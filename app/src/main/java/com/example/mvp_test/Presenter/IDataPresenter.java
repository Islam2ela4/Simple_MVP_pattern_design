package com.example.mvp_test.Presenter;


import com.example.mvp_test.View.IMainView;

public interface IDataPresenter {
    void onButtonClickStoreData(IMainView mainView, String f_name, String l_name, String email);

    void onButtonClickLoadData(IMainView mainView);
}
