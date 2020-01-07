package com.example.chichang_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class activity_setup_category extends AppCompatActivity {
    private Button back;

    ArrayList<String> categoryList;
    ArrayAdapter<String> adapter;
    EditText categoryText;
    Button add_button;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_category);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }

            public void openActivity1(){
                Intent intent = new Intent(activity_setup_category.this, MainActivity.class);
                //Intent intent = new Intent(this, SetupActivity.class);
                startActivity(intent);
            }
        });

        lv = (ListView) findViewById(R.id.listview);
        categoryText = (EditText) findViewById(R.id.txtinput);
        add_button = (Button) findViewById(R.id.add_button);

        categoryList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(activity_setup_category.this, android.R.layout.simple_list_item_multiple_choice, categoryList);

        View.OnClickListener addlistener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryList.add(categoryText.getText().toString());
                categoryText.setText("");
                adapter.notifyDataSetChanged();
            }
        };

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SparseBooleanArray positionchecker = lv.getCheckedItemPositions();
                int count = lv.getCount();
                for (int item = count-1; item>=0; item--){
                    if (positionchecker.get(item)){
                        adapter.remove(categoryList.get(item));

                        Toast.makeText(activity_setup_category.this ,"Category Delete Succeddfully" ,Toast.LENGTH_SHORT).show();
                    }
                }

                positionchecker.clear();
                adapter.notifyDataSetChanged();

            }
        });

        add_button.setOnClickListener(addlistener);

        lv.setAdapter(adapter);
    }
}