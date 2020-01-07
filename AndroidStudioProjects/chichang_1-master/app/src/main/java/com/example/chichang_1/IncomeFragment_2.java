package com.example.chichang_1;

import androidx.fragment.app.Fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeFragment_2 extends Fragment {
    private ListView ch1;
    ArrayList<String> selectedCategories = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_expense_2);

        View view = inflater.inflate(R.layout.fragment_expense_2, container, false);

        ch1 = (ListView) view.findViewById (R.id.checkable_list);
        ch1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] category={"Salary","Allowance","Award/Bonus","Others"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.rowlayout, R.id.txt_lan, category);
        ch1.setAdapter(adapter);
        ch1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String selectedCategory = ((TextView)view).getText().toString();
                if(selectedCategories.contains(selectedCategory)){
                    selectedCategories.remove(selectedCategory); //uncheck category
                }
                else
                    selectedCategories.add(selectedCategory);
            }
        });
        return view;
    }

    public void showSelectedCategories(View view) {
        String categories = "";
        for (String category:selectedCategories) {
            categories += "-" + categories + "\n";
        }
    }
}