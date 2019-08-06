package com.example.alquraan;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        btn1 = findViewById ( R.id.button1 );
        btn2 = findViewById ( R.id.button2 );
    }


    public void click(View view) {
        Fragment fragment = null;
        if (view.getId ()==R.id.button1){
            fragment=new QuraanFragment ();
        }
        else if (view.getId ()==R.id.button2){
            fragment = new RadioFragment ();
        }

        getSupportFragmentManager ()
                .beginTransaction ()
                .replace ( R.id.fragment_container,fragment )
                .commit ();
    }

}
