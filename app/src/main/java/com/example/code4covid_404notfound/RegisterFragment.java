package com.example.code4covid_404notfound;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegisterFragment extends Fragment {

    FirebaseAuth fAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register,container,false);
        Button register = v.findViewById(R.id.registration_btn);
        fAuth = FirebaseAuth.getInstance();
        EditText email = v.findViewById(R.id.email_reg);
        EditText passord = v.findViewById(R.id.passreg);

//        if(fAuth.getCurrentUser()!=null){
//            NewsFragment fragment = new NewsFragment();
//            getActivity().getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container,fragment).commit();
//            finish();
//        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = email.getText().toString().trim();
                String Password = passord.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(Password)){
                    passord.setError("Password is required");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(Email,Password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                NewsFragment fragment = new NewsFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,fragment).commit();
            }
        });
        return v;
    }
}