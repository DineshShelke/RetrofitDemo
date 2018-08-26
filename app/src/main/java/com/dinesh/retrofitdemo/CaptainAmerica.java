package com.dinesh.retrofitdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class CaptainAmerica {

    @SerializedName("contacts")
    @Expose
    private List<CaptainAmericaData> contacts = null;

    public List<CaptainAmericaData> getContacts() {
        return contacts;
    }

    public void setContacts(List<CaptainAmericaData> contacts) {
        this.contacts = contacts;
    }
}