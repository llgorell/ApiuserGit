package com.example.apigithub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitShowActivity extends AppCompatActivity {

    private TextView tv_name;
    private TextView tv_email;
    private TextView tv_blog;
    private TextView tv_company;
    private TextView tv_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_show);
        injecttextview();
        getgituser();
    }

    public void getgituser(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Githubinterface githubinterface = retrofit.create(Githubinterface.class);

        githubinterface.getgithubUser().enqueue(new Callback<Github>() {
            @Override
            public void onResponse(Call<Github> call, Response<Github> response) {
                tv_name.setText(response.body().getName());
//                tv_email.setText(response.body().getEmail().toString());
                tv_blog.setText(response.body().getBlog());
                tv_company.setText(response.body().getCompany());
                tv_location.setText(response.body().getLocation());


            }

            @Override
            public void onFailure(Call<Github> call, Throwable t) {

            }
        });
    }
    public void injecttextview(){
        tv_name = findViewById(R.id.tv_name);
        tv_email = findViewById(R.id.tv_email);
        tv_blog = findViewById(R.id.tv_blog);
        tv_company = findViewById(R.id.tv_company);
        tv_location = findViewById(R.id.tv_location);
    }
}
