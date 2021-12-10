package com.example.hw_week_11.ui.gallery;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.hw_week_11.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private EditText display;
    private TextView problem;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calculator, container, false);

        return root;
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


}