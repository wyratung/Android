package com.example.in4mation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, sdt,email,dob,mssv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        sdt=findViewById(R.id.sdt);
        email=findViewById(R.id.email);
        dob=findViewById(R.id.dob);
        mssv=findViewById(R.id.mssv);
    }

    public void Submit(View view) {
        if(name.getText().toString().equals("") && dob.getText().toString().equals("") && mssv.getText().toString().equals("")
                && sdt.getText().toString().equals("") && email.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "You need to fill your information!", Toast.LENGTH_LONG).show();

        }
        else
            Toast.makeText(MainActivity.this, "Data has been saved successfully!", Toast.LENGTH_LONG).show();
    }
}