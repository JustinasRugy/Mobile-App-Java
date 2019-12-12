package com.example.dg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registracija extends AppCompatActivity {


    EditText etname, etuname, etpass, etrep;
    String name, uname, pass, rep;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracija);


        etname = (EditText) findViewById(R.id.name);
        etuname = (EditText) findViewById(R.id.uname);
        etpass = (EditText) findViewById(R.id.pass);
        etrep = (EditText) findViewById(R.id.rep);
        b = (Button) findViewById(R.id.registracija);



    }

    public void userReg(View view){

        name = etname.getText().toString();
        uname = etuname.getText().toString();
        pass = etpass.getText().toString();
        rep = etrep.getText().toString();
        String method ="register";
        if (name.equals("") || uname.equals("") || pass.equals("") || rep.equals("")) {

            Toast.makeText(Registracija.this, "Duomenys neteisingi...",Toast.LENGTH_SHORT).show();
        } else if (pass.equals(rep)) {
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(method, name, uname, pass);
            finish();


        } else {
            Toast.makeText(Registracija.this, "Slaptazodziai skirtingi...",Toast.LENGTH_SHORT).show();
        }


    }


}
