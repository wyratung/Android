package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.PrimitiveIterator;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    private TextView problem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.blank);
        problem=findViewById(R.id.problem);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            display.setShowSoftInputOnFocus(false);
        }
    }
    private void updateText(String strToAdd){
        String oldStr= display.getText().toString();
        int cursorPos=display.getSelectionStart();
        String leftStr= oldStr.substring(0,cursorPos);
        String rightStr= oldStr.substring(cursorPos);
        if(getString(R.string.hint).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos+1);
        }else{
            display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
            display.setSelection(cursorPos+1);
        }

    }

    public void btnMod(View view) {
        updateText("%");
    }

    public void btnNega(View view) {
        updateText("-");
    }

    public void btnCE(View view) {
        display.setText("");
    }

    public void btnDel(View view) {
        int cursorPos= display.getSelectionStart();
        int textLen=display.getText().length();
        if(cursorPos !=0 && textLen!=0 ){
            SpannableStringBuilder selection= (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void btn7(View view) {
        updateText("7");
    }

    public void btn8(View view) {
        updateText("8");
    }

    public void btn9(View view) {
        updateText("9");
    }

    public void btnMul(View view) {
        updateText("*");
    }

    public void btn4(View view) {
        updateText("4");
    }

    public void btn5(View view) {
        updateText("5");
    }

    public void btn6(View view) {
        updateText("6");
    }

    public void btnSub(View view) {
        updateText("-");
    }

    public void btn1(View view) {
        updateText("1");
    }

    public void btn2(View view) {
        updateText("2");
    }

    public void btn3(View view) {
        updateText("3");
    }

    public void btnPlus(View view) {
        updateText("+");
    }

    public void btnDot(View view) {
        updateText(".");
    }

    public void btn0(View view) {
        updateText("0");
    }

    public void btnDivide(View view) {
        updateText("/");
    }

    public void btnEqual(View view) {
        String userExp= display.getText().toString();
        String calculation= display.getText().toString()+"=";
        problem.setText(calculation);
        Expression exp= new Expression(userExp);
        String result= String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }
}