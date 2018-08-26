package com.dinesh.retrofitdemo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceHelper {
    //    public static String BASEURL = "https://api.androidhive.info/contacts/";
    public static String BASEURL = "https://api.androidhive.info/";

    private static ServiceHelper instance = new ServiceHelper();

    private RequestInterface service;

    public static ServiceHelper getInstance() {
        return instance;
    }

    private ServiceHelper() {
        Retrofit retrofit = CreateAdapter().build();
        service = retrofit.create(RequestInterface.class);
    }

    private Retrofit.Builder CreateAdapter() {
        return new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create());
    }

//    public Call<CaptainAmerica> getContactData(String uid,String otp){
//        return service.getContactData();
//    }

    public Call<CaptainAmerica> getContactData() {
        return service.getContactData();
    }
}
