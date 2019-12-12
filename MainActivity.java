package com.example.dg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button b1, register;
    EditText edit1, edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = (Button) findViewById(R.id.button);
        edit1 = (EditText) findViewById(R.id.userName);
        edit2 = (EditText) findViewById(R.id.pass);
        register = (Button) findViewById(R.id.toReg);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openRegistracija();
            }
        });



    }

    public void onLogin(View view){
        String username = edit1.getText().toString();
        String password = edit2.getText().toString();
        String method = "login";
        FetchData fd = new FetchData(this);
        fd.execute();



        if (username.equals("") || password.equals("")) {
            Toast.makeText(this, "Neteisingas vartotojo vardas arba slaptazodis...", Toast.LENGTH_LONG).show();
        } else {

            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(method,username,password);
            openUzsakymai();
        }



    }

    private void openUzsakymai() {
        Intent inte = new Intent(this, Uzsakymai.class);
        startActivity(inte);
    }

    private void openRegistracija() {
        Intent inte = new Intent(this,  Registracija.class);
        startActivity(inte);
    }
}
