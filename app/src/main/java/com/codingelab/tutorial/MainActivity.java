package com.codingelab.tutorial;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText etFirstName,etLastName,etFavFood;
    private Button btnView,btnAdd;

    //private Syn syn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


       // this.syn=new Syn();
        // preparing listener (onAction)
        etFavFood = (EditText) findViewById(R.id.etFavFood);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        final Intent intent = new Intent(this, ViewListContents.class);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = etFirstName.getText().toString();
                String lName = etLastName.getText().toString();
                String fFood = etFavFood.getText().toString();
                if(fName.length() != 0 && lName.length() != 0 && fFood.length() != 0){
                    AddData(fName,lName, fFood);
                    etFavFood.setText("");
                    etLastName.setText("");
                    etFirstName.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnView = (Button) findViewById(R.id.btnView);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
    public void AddData(String firstName,String lastName, String favFood ){
        boolean insertData = true;//myDB.addData(firstName,lastName,favFood);

        if(insertData==true){
            Toast.makeText(MainActivity.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }

}
