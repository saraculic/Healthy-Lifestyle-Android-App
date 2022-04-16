package com.example.projekat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistracijaActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button registracijaDugme;
    RegistracijaDatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracija);

        username = (EditText) findViewById(R.id.usernameRegistracija);
        password = (EditText) findViewById(R.id.passwordRegistracija);
        repassword = (EditText) findViewById(R.id.repassword);
        registracijaDugme = (Button) findViewById(R.id.registracijaDugme);
        DB = new RegistracijaDatabaseHelper(this);

        registracijaDugme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(RegistracijaActivity.this, "Morate popuniti sva polja", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser == false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert == true){
                                Toast.makeText(RegistracijaActivity.this, "Uspesno ste se registrovali", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegistracijaActivity.this, "Registracija nije uspela", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegistracijaActivity.this, "Korisnik već postoji, ulogujte se!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegistracijaActivity.this, "Lozinke se ne poklapaju!", Toast.LENGTH_SHORT).show();
                    }
                } }
        });
    }
}