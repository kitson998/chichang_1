package com.example.chichang_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class Income extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<String>();
    TextView final_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        final_text = (TextView) findViewById(R.id.final_result);
        final_text.setEnabled(false);
    }

    public void selectItem(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.salary:
                if (checked){
                    selection.add("Salary");}
                else {
                    selection.remove("Salary");
                }
                break;

            case R.id.allowance:
                if (checked){
                    selection.add("Allowance");}
                else {
                    selection.remove("Allowance");
                }
                break;

            case R.id.award_bonus:
                if (checked){
                    selection.add("Award/Bonus");}
                else {
                    selection.remove("Award/Bonus");
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
