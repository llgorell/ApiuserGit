package com.example.apigithub;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Githubinterface {




    @GET("users/llgorell")
    Call<Github> getgithubUser();
}
