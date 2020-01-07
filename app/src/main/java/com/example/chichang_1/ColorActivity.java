package com.example.chichang_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity {

    Toolbar mToolbar;
    Button mRed;
    Button mBlack;
    Button mDefault;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mToolbar = findViewById(R.id.toolbar);
        mRed = findViewById(R.id.btnRed);
        mBlack = findViewById(R.id.btnBlack);
        mDefault = findViewById(R.id.btnDefault);

        back = findViewById(R.id.btnBack);

        mToolbar.setTitle(getResources().getString(R.string.app_name));

        if(getColor() != getResources().getColor(R.color.colorPrimary)){
            mToolbar.setBackgroundColor(getColor());
            getWindow().setStatusBarColor(getColor());
        }

        mRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.colorRed));
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
                storeColor(getResources().getColor(R.color.colorRed));
            }
        });

        mBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlack));
                storeColor(getResources().getColor(R.color.colorBlack));
            }
        });

        mDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
                storeColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ColorActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void storeColor(int color){
        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt("color", color);
        mEditor.apply();
    }
    private int getColor(){
        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor", MODE_PRIVATE);
        int selectedColor = mSharedPreferences.getInt("color", getResources().getColor(R.color.colorPrimary));
        return selectedColor;
    }

}
