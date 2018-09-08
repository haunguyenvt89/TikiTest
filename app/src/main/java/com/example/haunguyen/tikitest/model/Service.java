package com.example.haunguyen.tikitest.model;

import android.content.Context;

import com.example.haunguyen.tikitest.presenter.INetWorkInterator;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service implements IService {
    private INetWorkInterator mOnGetDatalistener;

    public Service(INetWorkInterator mOnGetDatalistener){
        this.mOnGetDatalistener = mOnGetDatalistener;
    }
    @Override
    public void initRetrofitCall(Context context, String url) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        NetWorkService request = retrofit.create(NetWorkService.class);
        retrofit2.Call<String[]> call = request.getProduct();
       call.enqueue(new Callback<String[]>() {
           @Override
           public void onResponse(Call<String[]> call, Response<String[]> response) {
                mOnGetDatalistener.onSuccess("Success", response.body());
           }

           @Override
           public void onFailure(Call<String[]> call, Throwable t) {
                mOnGetDatalistener.onFailure("Fail");
           }
       });
    }
}