package com.dinesh.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RequestInterface {


    //@FormUrlEncoded

    @POST(Constant.getContactData)
    Call<CaptainAmerica> getContactData();

//    @FormUrlEncoded
//    @POST(Constant.getContactData)
//    Call<CaptainAmericaData> getContactData(@Field("UID") String strUid, @Field("OTP") String strOtp);
}
