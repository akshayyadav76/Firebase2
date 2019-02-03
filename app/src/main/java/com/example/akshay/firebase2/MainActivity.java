package com.example.akshay.firebase2;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String akshay;
    int x=400;
    int y=500;
    // firebase is working first time right with database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseReference def=FirebaseDatabase.getInstance().getReference();

        Map<String,String>Values=new HashMap<>();
        Values.put("name","akshay");

        def.push().setValue(Values, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if(databaseError == null)
                {
                    Log.i("see","save sucsses")
                    ;
                }else
                {
                    Log.i("see","not saved");
                }
            }
        });


    }
}
