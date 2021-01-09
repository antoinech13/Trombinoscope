package com.example.trombinoscope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Button add;
    protected Button ed;
    protected Button exp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.add = (Button) findViewById(R.id.Ajouter);
        this.ed = (Button) findViewById(R.id.éditer);
        this.exp = (Button) findViewById(R.id.exporter);

        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent addAct = new Intent(getApplicationContext(), AddAct.class);
                startActivity(addAct);
                finish();
            }
        });
    }
}