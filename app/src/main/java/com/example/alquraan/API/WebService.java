package com.example.alquraan.API;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {

    @GET("radios/radio_arabic.json")
    Call<RadioChannelsResponse> getRadioChannels();
}
