package com.example.chichang_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_setup_color extends AppCompatActivity {
    private Button back;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_color);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSetup1();
            }
        });
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.colorPrimary);
    }
    public void openSetup1(){
        Intent intent = new Intent(this, SetupActivity.class);
        startActivity(intent);
    }
    public void goBlue(View view){
        view.setBackgroundResource(R.color.colorPrimary);
    }
    public void goDarkGray(View view){
        view.setBackgroundResource(R.color.colorDarkGray);
    }
    public void goDarkGreen(View view){
        view.setBackgroundResource(R.color.colorDarkGreen);
    }
    public void goPink(View view){
        view.setBackgroundResource(R.color.colorPink);
    }
}
