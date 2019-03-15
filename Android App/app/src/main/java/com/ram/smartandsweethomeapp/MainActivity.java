package com.ram.smartandsweethomeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    Button login;
    EditText uid,pwd;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setContentView(R.layout.activity_main);
        uid=(EditText)findViewById(R.id.uid);
        pwd=(EditText)findViewById(R.id.pwd);
        login=(Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(uid.getText().toString(),pwd.getText().toString());
            }
        });


    }


    private void validate(String user,String pass)
    {
        if((user.equals("MI101"))&&(pass.equals("1234")))
        {
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Enter valid UserId and password",Toast.LENGTH_LONG).show();
        }
    }





}
