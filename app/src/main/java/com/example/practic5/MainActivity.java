package com.example.practic5;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        setFragment(new FirstFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.first_item) {
                setFragment(new FirstFragment());
                return true;
            } else if (itemId == R.id.second_item) {
                setFragment(new SecondFragment());
                return true;
            } else if (itemId == R.id.third_item) {
                setFragment(new ThirdFragment());
                return true;
            }

            return false;
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == (R.id.first_item)){
            setFragment(new FirstFragment());
        } else if (id == (R.id.second_item)){
            setFragment(new SecondFragment());
        } else if (id == (R.id.third_item)) {
            setFragment(new ThirdFragment());
        }
        return true;
    }

    public void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.selectedMenu, fragment, null).commit();
    }
}