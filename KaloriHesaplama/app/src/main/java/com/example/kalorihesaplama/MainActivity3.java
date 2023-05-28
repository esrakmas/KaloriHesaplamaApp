package com.example.kalorihesaplama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity3 extends AppCompatActivity {
    BottomNavigationView BottomNavi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        BottomNavi = findViewById(R.id.bnavi);
        //ilk home gelcek
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new besinF()).commit();
        BottomNavi.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.besin:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler, new besinF()).commit();
                        break;

                    case R.id.rapor:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler, new raporF()).commit();
                        break;


                }

                return true;
            }
        });


    }}