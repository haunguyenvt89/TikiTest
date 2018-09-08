package com.example.haunguyen.tikitest.presenter;

public interface IMainView {

    void showProgress();

    void hideProgress();

    void setDataToRecyclerView();

    void onGetDataSuccess(String message, String[] list);

    void onGetDataFailure(String message);
}
