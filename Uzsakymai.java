package com.example.dg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.Collections;


public class Uzsakymai extends AppCompatActivity {

    TextView tv;
    Button logout;


    private String[] load_city;
    private String[] discharge_city;

    public Uzsakymai()
    {}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uzsakymai);

        tv = (TextView) findViewById(R.id.textView);
        logout = (Button) findViewById(R.id.logout);
        ListView lv = (ListView) findViewById(R.id.ViewList);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Collections.singletonList((load_city + " - " + discharge_city)));
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent inte = new Intent(Uzsakymai.this, Info.class);
                inte.putExtra("int_value", position);
                startActivity(inte);

            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

    }

        private void openInfo() {
        Intent inte = new Intent(this, Info.class);
        startActivity(inte);
    }

    private void openMain() {
        Intent inte = new Intent(this, MainActivity.class);
        startActivity(inte);
    }

}
