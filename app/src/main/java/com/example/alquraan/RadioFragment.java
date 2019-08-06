package com.example.alquraan;


import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alquraan.API.APIManger;
import com.example.alquraan.API.RadioChannelsResponse;
import com.example.alquraan.API.RadiosItem;
import com.example.alquraan.Base.BaseActivity;
import com.example.alquraan.Base.BaseFragment;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends Fragment {


    public RadioFragment() {
        // Required empty public constructor
    }
    public BaseActivity activity;
    AlertDialog alertDialog;

    RecyclerView recycler_View2;
    RadioChannelsAdapter adapter2;

    View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate ( R.layout.fragment_radio, container, false );
        recycler_View2= view.findViewById ( R.id.recycle_View2 );
        initRecycler ();
        getRadioChannelsFromApi ();
        return view;
    }


    public void initRecycler(){
        recycler_View2.setLayoutManager ( new LinearLayoutManager
                ( activity ,LinearLayoutManager.HORIZONTAL,false) );
        adapter2 = new RadioChannelsAdapter ( null );
        recycler_View2.setAdapter ( adapter2 );
        final SnapHelper snapHelper = new PagerSnapHelper ();
        snapHelper.attachToRecyclerView ( recycler_View2 );
        adapter2.setOnPlayClickListner ( new RadioChannelsAdapter.OnItemClickListener () {
            @Override
            public void onItemClick(int position, RadiosItem radiosItem) {

                playChannel ( radiosItem.getRadioUrl () );
            }
        } );
        adapter2.setOnStopClickListner ( new RadioChannelsAdapter.OnItemClickListener () {
            @Override
            public void onItemClick(int position, RadiosItem radiosItem) {

                stopChannel ();
            }
        } );

    }
    MediaPlayer mediaPlayer;

    public void playChannel(String url){
        stopChannel ();
        mediaPlayer=new MediaPlayer ();



        try {

            mediaPlayer.setDataSource ( url );
            mediaPlayer.prepareAsync ();
            mediaPlayer.setOnPreparedListener ( new MediaPlayer.OnPreparedListener () {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start ();
                }
            } );
        } catch (IOException e) {

        }

    }
    public void stopChannel(){
        if (mediaPlayer!=null&&mediaPlayer.isPlaying ()){
            mediaPlayer.stop ();
        }

    }



    public void getRadioChannelsFromApi(){
        APIManger.getApis ().getRadioChannels ()
                .enqueue ( new Callback<RadioChannelsResponse> () {
                    @Override
                    public void onResponse(Call<RadioChannelsResponse> call
                            , Response<RadioChannelsResponse> response) {

                        adapter2.changeData ( response.body ().getRadios () );
                    }

                    @Override
                    public void onFailure(Call<RadioChannelsResponse> call, Throwable t) {

                    }
                } );
    }












}
