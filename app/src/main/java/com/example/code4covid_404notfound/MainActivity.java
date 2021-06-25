package com.example.code4covid_404notfound;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.code4covid_404notfound.databinding.ActivityMainBinding;

import me.ibrahimsn.lib.OnItemSelectedListener;
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
//        by default in home it shows fragmnet
        FragmentTransaction homeTrans = getSupportFragmentManager().beginTransaction();
        homeTrans.replace(R.id.fragment_container,new NewsFragment());
        homeTrans.commit();


//        custom navbar-1 smooth bar
        binding.bottomNav.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //int i -i is index not menu item lib
                switch (i){
                    case 0:
                        transaction.replace(R.id.fragment_container,new NewsFragment());
                        break;
                    case 1:
                        transaction.replace(R.id.fragment_container,new DoctorFragment() );
                        break;
                    case 2:
                        transaction.replace(R.id.fragment_container,new FourmFragment());
                        break;
                    case 3:
                        transaction.replace(R.id.fragment_container,new VaccineFragment());
                        break;

                    case 4:
                        transaction.replace(R.id.fragment_container,new QuizeFragment());
                        break;

                }
                transaction.commit();
                return false;//but in normal its true.
            }
        });

    }
}