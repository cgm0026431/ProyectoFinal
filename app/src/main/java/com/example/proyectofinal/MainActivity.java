package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayoutt;
    private home option1Fragment;
    private newFormulario option2Fragment;
    private seting option3Fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        option1Fragment = new home();
        option2Fragment = new newFormulario();
        option3Fragment = new seting();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayoutt = findViewById(R.id.fragment);

        setFragment(option1Fragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        //bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);

                        setFragment(option1Fragment);
                        return true;
                    case R.id.menu_profile:
                        //bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(option2Fragment);
                        return true;
                    case R.id.menu_settings:
                        // bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(option3Fragment);
                        return true;
                }
                return false;
            }
        });
    } private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTrasaction = getSupportFragmentManager().beginTransaction();
        fragmentTrasaction.replace(R.id.fragment, fragment);
        fragmentTrasaction.commit();
    }
}