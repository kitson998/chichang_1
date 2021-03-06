package com.example.chichang_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class Expense extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<String>();
    TextView final_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        final_text = (TextView) findViewById(R.id.final_result);
        final_text.setEnabled(false);
    }

    public void selectItem(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.food:
                if (checked){
                    selection.add("Food");}
                else {
                    selection.remove("Food");
                }
                break;

            case R.id.clothing:
                if (checked){
                    selection.add("Clothing");}
                else {
                    selection.remove("Clothing");
                }
                break;

            case R.id.housing:
                if (checked){
                    selection.add("Housing");}
                else {
                    selection.remove("Housing");
                }
                break;

            case R.id.transportation:
                if (checked){
                    selection.add("Transportation");}
                else {
                    selection.remove("Transportation");
                }
                break;

            case R.id.education:
                if (checked){
                    selection.add("Education");}
                else {
                    selection.remove("Education");
                }
                break;

            case R.id.entertainment:
                if (checked){
                    selection.add("Entertainment");}
                else {
                    selection.remove("Entertainment");
                }
                break;
            case R.id.others:
                if (checked){
                    selection.add("Others");}
                else {
                    selection.remove("Others");
                }
                break;
        }
    }

    public void finalSelection(View view){
        String final_category_selection = "";

        for (String Selections : selection) {
            final_category_selection = final_category_selection + Selections + "\n";
        }

        final_text.setText(final_category_selection);
        final_text.setEnabled(true);
    }
}
