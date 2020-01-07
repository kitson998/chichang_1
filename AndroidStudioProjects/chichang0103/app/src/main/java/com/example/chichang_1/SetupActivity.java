package com.example.chichang_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SetupActivity extends AppCompatActivity {
    private Button theme_color;
    private Button add_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        theme_color = (Button) findViewById(R.id.theme_color);
        add_category = (Button) findViewById(R.id.add_category);
        theme_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColor();
            }
        });
        add_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCategory();
            }
        });

        // initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.main_nav);
        // set home select
        bottomNavigationView.setSelectedItemId(R.id.setup);
        // perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.graph:
                        startActivity(new Intent(getApplicationContext()
                                , GraphActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.setup:
                        return true;
                }
                return false;
            }
        });


    }
    public void openColor(){
        Intent intent = new Intent(this, ColorActivity.class);
        startActivity(intent);
    }
    public void openCategory(){
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }
}
