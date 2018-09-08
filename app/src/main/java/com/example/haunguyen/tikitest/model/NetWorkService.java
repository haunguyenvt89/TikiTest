package com.example.haunguyen.tikitest.model;


import retrofit2.Call;
import retrofit2.http.GET;

public interface NetWorkService {
    @GET("/talenguyen/38b790795722e7d7b1b5db051c5786e5/raw/63380022f5f0c9a100f51a1e30887ca494c3326e/keywords.json")
    Call<String[]> getProduct();
}
