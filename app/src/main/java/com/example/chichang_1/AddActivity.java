package com.example.chichang_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddActivity extends AppCompatActivity {

    private Spinner Typespinner;
    private boolean isIncome;

    private ArrayAdapter<CharSequence> ExpenseAdapter;
    private ArrayAdapter<CharSequence> IncomeAdapter;

    private EditText Addamount;
    private Button ADDbutton;
    private Button Add_backbtn;

    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;

    private String current_user_id;
    private String Add_date;
    private String Add_itemname;
    private ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        isIncome = getIntent().getBooleanExtra("isIncome",true);

        Typespinner = findViewById(R.id.add_typespinner);
        ExpenseAdapter = ArrayAdapter.createFromResource(
                this, R.array.add_expenselist, android.R.layout.simple_spinner_item );
        IncomeAdapter = ArrayAdapter.createFromResource(
                this, R.array.add_incomelist, android.R.layout.simple_spinner_item);

        Typespinner.setAdapter(ExpenseAdapter);
        Typespinner.setAdapter(IncomeAdapter);

        ADDbutton = findViewById(R.id.add_btn);
        Add_backbtn = findViewById(R.id.add_backbtn);
        if (isIncome){

            IncomeAdapter.setDropDownViewResource(
                    android.R.layout.simple_spinner_dropdown_item);
            Typespinner.setAdapter(IncomeAdapter);
        }else{
            ExpenseAdapter.setDropDownViewResource(
                    android.R.layout.simple_spinner_dropdown_item);
            Typespinner.setAdapter(ExpenseAdapter);
        }
        /*ADDbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                Addamount = findViewById(R.id.add_numtext);
                Add_itemname= ((EditText)findViewById(R.id.add_editItem)).getText().toString();
                if (!Addamount.getText().toString().equals("")){
                    //String id = UUID.randomUUID().toString();
                    int add = Integer.parseInt(Addamount.getText().toString());
                    final boolean chosenIE  = IEspinner.getSelectedItem().toString().equals("Income");
                    String chosenType =Typespinner.getSelectedItem().toString();
                    Post newpost = new Post(Add_itemname,chosenType,current_user_id,Add_date,chosenIE,add);

//                    Map<String,Object> PostMap = new HashMap<>();
//                    PostMap.put("Id",id);
//                    PostMap.put("Income or Expense",chosenIE);
//                    PostMap.put("Type",chosenType);
//                    PostMap.put("Item_name",Add_itemname);
//                    PostMap.put("Amount",add);
//                    PostMap.put("User_id",current_user_id);
//                    PostMap.put("Date",Add_date);


                    firebaseFirestore.collection("Posts").add(newpost)
//                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    Toast.makeText(AddActivity.this,"Post was added!",Toast.LENGTH_LONG).show();
//                                    sendToDate();
//                                }
//                            })
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(AddActivity.this,"Post was added!",Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.INVISIBLE);
                                    sendToDate();

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.INVISIBLE);
                                }
                            });

                }else{
                    Toast.makeText(AddActivity.this,"Please input an amount!",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }

            }
        });*/


        Add_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, CostActivity.class);
                startActivity(intent);
            }
        });






    }
}
