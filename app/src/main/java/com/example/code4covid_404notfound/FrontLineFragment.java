package com.example.code4covid_404notfound;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class FrontLineFragment extends Fragment {

    CardView cardDoc;
    CardView cardMed;
    CardView cardVol;
    CardView cardOxy;
    CardView cardCare;
    CardView cardOthers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_frontline, container, false);
//        setContentView(R.layout.activity_main);
        View v = inflater.inflate(R.layout.fragment_frontline,container,false);
        cardDoc = v.findViewById(R.id.doctor);
        cardMed = v.findViewById(R.id.medical);
        cardVol = v.findViewById(R.id.voluenteer);
        cardOxy = v.findViewById(R.id.oxygen);
        cardCare = v.findViewById(R.id.caretaker);
        cardOthers = v.findViewById(R.id.others);

        cardDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("doc clicked");
            }
        });
        cardMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(" cardMed clicked");
            }
        });
        cardVol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("vol clicked");
            }
        });
        cardOxy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("oxy clicked");
            }
        });

        cardCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("care clicked");
            }
        });

        cardOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("others clicked");
            }
        });

        return v;
    }


    private void showToast(String message){
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
    }
}