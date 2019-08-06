package com.example.alquraan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SewarDetail extends AppCompatActivity {
    static  int postion;
    static  String sewarname;
    String intentSewarName;
    int intentSewarPosition;
    ArrayList<String> suraContent;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SuraContentRecuclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_sewar_detail );
        recyclerView = findViewById ( R.id.recycle_view );
        intentSewarName =getIntent ().getStringExtra ( "sewarname" );
        intentSewarPosition = getIntent ().getIntExtra ( "position",-1 );

        readSurafromFile ( (postion +1)+".txt" );
        layoutManager=new LinearLayoutManager ( this );
        adapter=new SuraContentRecuclerAdapter ( suraContent );
        recyclerView.setAdapter ( adapter );
        recyclerView.setLayoutManager ( layoutManager );

    }

    public void readSurafromFile(String fileName){

        BufferedReader reader ;
        try {
            suraContent = new ArrayList<> (  );
            final InputStream file = getAssets ().open ( fileName );
            reader = new BufferedReader ( new InputStreamReader ( file ) );
            String line = reader.readLine ();
            while (line!=null){
                Log.d("StackOverflow",line);
                line = reader.readLine ();
                suraContent.add ( line );
            }

        }
        catch (IOException ioe){
            ioe.printStackTrace ();
        }

    }}


