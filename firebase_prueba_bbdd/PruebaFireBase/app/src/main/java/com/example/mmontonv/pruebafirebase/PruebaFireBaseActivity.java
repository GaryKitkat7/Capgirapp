package com.example.mmontonv.pruebafirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PruebaFireBaseActivity extends AppCompatActivity {

    TextView mConditionTextView;
    EditText EditTextFB;
    Button BotoGuardar;
    private String Condicio = "condition";
    int i = 0;
    Llista lista;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = mRootRef.child(Condicio);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_fire_base);

        //get UI elements
        mConditionTextView = (TextView) findViewById(R.id.tvCondition);
        BotoGuardar = (Button) findViewById(R.id.BotoGuardar);
        EditTextFB = (EditText) findViewById(R.id.editTextFB);
    }
    @Override
    protected void onStart(){
        super.onStart();

        BotoGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Text = EditTextFB.getText().toString();
                mConditionRef = mRootRef.child(Condicio+i);
                if(!lista.Trobar(Text)){
                    lista.Afegir(Text);
                    mConditionRef.setValue(Text);
                    mConditionTextView.setText(Text);
                }
                i++;
            }

        });

        /*mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mConditionTextView.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/






    }
}