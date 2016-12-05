package com.example.mmontonv.pruebafirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class PruebaFireBase extends AppCompatActivity {

    EditText mConditionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_fire_base);
        onStart();

    }
    @Override
    protected void onStart(){
        super.onStart();
        mConditionTextView = (EditText) findViewById(R.id.tvCondition);
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mConditionRef = mRootRef.child("condition");
        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class); // String que almacena los datos retornados.
                mConditionTextView.setText(text); // Volcamos los datos en el TextView
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
