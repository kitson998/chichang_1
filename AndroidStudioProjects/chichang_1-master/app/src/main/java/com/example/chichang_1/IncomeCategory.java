//package com.example.chichang_1;
//
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//
//public class IncomeCategory extends AppCompatActivity {
//    ListView listView_income;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_income_2);
//
//        listView_income = (ListView)findViewById(R.id.listView_income);
//
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("薪資");
//        arrayList.add("獎金");
//        arrayList.add("發票");
//        arrayList.add("投資");
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
//
//        listView_income.setAdapter(arrayAdapter);
//    }
//}
