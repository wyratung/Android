package com.example.convert2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.sql.Array;
import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Logger;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    String[] items = { "binary(2)", "octal(8)","decimal(10)","hexadecimal(16)" };
    Spinner spinner1,spinner2;
    EditText input,output;
    String getInput,ipFactor,opFactor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1=(Spinner) findViewById(R.id.spinner1);
        spinner2=(Spinner) findViewById(R.id.spinner2) ;
        input= findViewById(R.id.input);
        output= findViewById(R.id.output);
        getInput= input.getText().toString();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,items );
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> spinner, View view, int position, long id) {
        int tmp = spinner.getId();
        switch (tmp) {
            case R.id.spinner1:
                ipFactor = String.valueOf(position);
                Toast toast = Toast.makeText(this, String.valueOf(position),
                        Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.spinner2:
                opFactor = String.valueOf(position);
                 toast = Toast.makeText(this,String.valueOf(position) ,
                        Toast.LENGTH_LONG);
                toast.show();
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void convert(View view) {
        if (getInput == null){
            Toast toast = Toast.makeText(this, "Bạn chưa nhập cơ số cần chuyển đổi!!",
                    Toast.LENGTH_LONG);
            toast.show();

        }else{
            Convert(getInput,ipFactor,opFactor);
        }

    }
    String HexToBinary(String Hex) {
        String bin =  new BigInteger(Hex, 16).toString(2);
        int inb = Integer.parseInt(bin);
        bin = String.format(Locale.getDefault(),"%08d", inb);
        return bin;
    }

    public void Convert(String getInput,String ipFactor,String opFactor) {
        String bin =  new BigInteger(getInput, Integer.parseInt(ipFactor)).toString(Integer.parseInt(opFactor));
        int inb = Integer.parseInt(bin);
        bin = String.format(Locale.getDefault(),"%08d", inb);
        output.setText(bin);
    }
}