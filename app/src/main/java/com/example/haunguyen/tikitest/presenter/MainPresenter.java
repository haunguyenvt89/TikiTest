package com.example.haunguyen.tikitest.presenter;

import android.content.Context;

import com.example.haunguyen.tikitest.model.IService;
import com.example.haunguyen.tikitest.model.Service;

public class MainPresenter implements INetWorkInterator, IService {

    IMainView netWorkInterator;
    Service service;

    public MainPresenter(IMainView mGetDataView){
        this.netWorkInterator = mGetDataView;
        service = new Service(this);
    }

    @Override
    public void onSuccess(String message, String[] list) {
        netWorkInterator.onGetDataSuccess(message, list);
        netWorkInterator.setDataToRecyclerView();
        netWorkInterator.hideProgress();
    }

    @Override
    public void onFailure(String message) {
        netWorkInterator.onGetDataFailure(message);
        netWorkInterator.hideProgress();
    }

    @Override
    public void initRetrofitCall(Context context, String url) {
        service.initRetrofitCall(context, url);
        netWorkInterator.showProgress();
    }
}
