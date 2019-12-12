package com.example.dg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Info extends AppCompatActivity {

    public static TextView info ;
    Button atgal, patv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        String[] atve = {"Palanga - Vilnius          Tipas: XPS 13 9370           Turis: 2,635 m3               Mase: 1000kg             Kiekis: 10", "aodfnaisd", "Antakalnis - Passilaiciai            Tipas: XPS 31 5684"};

        patv = (Button) findViewById(R.id.patv);
        atgal =(Button) findViewById(R.id.back);
        info = (TextView) findViewById(R.id.marInfo);
        String index = getIntent().getStringExtra("temp");
        Intent intent = getIntent();
        int temp =intent.getIntExtra("int_value",0);
        info.setText(atve[temp]);

        atgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUzsakymai();
            }
        });
        patv.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                openUzsakymai();
                Intent i = new Intent(getApplicationContext(), Pop_up.class);
                startActivity(i);

            }
        });


    }

    private void openUzsakymai() {
        Intent inte = new Intent(this, Uzsakymai.class);
        startActivity(inte);
    }


}