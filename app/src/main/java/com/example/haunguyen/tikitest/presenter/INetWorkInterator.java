package com.example.haunguyen.tikitest.presenter;

public interface INetWorkInterator {
    void onSuccess(String message, String [] list);
    void onFailure(String message);
}
