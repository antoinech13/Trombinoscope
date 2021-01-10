package com.example.trombinoscope;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.trombinoscope.ui.login.LoginActivity;

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

        Intent i = new Intent(this, LoginActivity.class);
        startActivityForResult(i, 123);


        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent addAct = new Intent(getApplicationContext(), AddAct.class);
                startActivity(addAct);
                finish();
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 123) {
            if(resultCode == Activity.RESULT_OK){

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Intent i = new Intent(this, LoginActivity.class);
                startActivityForResult(i, 123);
            }
        }
    }
}