package com.example.projekat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;
    TextView registracija;
    RegistracijaDatabaseHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.loginbtn);
        registracija = (TextView) findViewById(R.id.registracija);

        DB = new RegistracijaDatabaseHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this, "Morate popuniti sva polja", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass == true){
                        Toast.makeText(MainActivity.this, "Uspesno ste se prijavili :)", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "GRESKA!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        registracija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistracijaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClickRegistration(View view) {
        Intent intent = new Intent(MainActivity.this, RegistracijaActivity.class);
        startActivity(intent);
    }

}