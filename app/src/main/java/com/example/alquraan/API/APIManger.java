package com.example.alquraan.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManger {

    private static Retrofit retrofit;

    public static Retrofit getInstance(){
        if (retrofit==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl("http://api.mp3quran.net/")
                    .addConverterFactory ( GsonConverterFactory.create () )
                    .build();

        }
        return retrofit;
    }

    public static WebService getApis(){
       return getInstance ().create ( WebService.class );
    }
}
