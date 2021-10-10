package com.example.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount=0;
    private TextView mShowCount;
    private  View buttonZero;
    private  View buttonCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.textView);
        buttonZero= (View)findViewById(R.id.button_zezo);
        buttonCount=(View) findViewById(R.id.button_count);
    }
    public void countUp(View view) {
        ++mCount;
        if(mCount>0) buttonZero.setBackgroundColor(0xFF00796B);
        if(mCount%2==1) buttonCount.setBackgroundColor(0xFF206CB8);
        else
            buttonCount.setBackgroundColor(0xFFD32F2F);
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void setToZezo(View view) {

        if (mShowCount != null){
            mCount=0;
            mShowCount.setText("0");
            buttonZero.setBackgroundColor(0xFFD32F2F);
        }

    }
}