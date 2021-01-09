package com.example.trombinoscope;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AddAct extends AppCompatActivity {


    public static final int CAMERA_REQUEST_CODE = 102;
    private Button photo, gallerie, suivant;
    private ImageView image;
    private TextInputEditText nom, prenom;
    private static final int PERMISSION_REQUEST_CODE = 200;
    private Bitmap img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        this.photo = (Button) findViewById(R.id.photo);
        this.gallerie = (Button) findViewById(R.id.galleryBtn);
        this.suivant = (Button) findViewById(R.id.suivant);

        this.nom = (TextInputEditText) findViewById(R.id.nom);
        this.prenom = (TextInputEditText) findViewById(R.id.prenom);

        this.image = (ImageView) findViewById(R.id.image);


        photo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                if (checkPermission())
                    openCamera();
                else
                    requestPermission();
            }
        });

        suivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                clear();
            }
        });


    }

    private void clear() {
        this.nom.getText().clear();
        this.prenom.getText().clear();
        this.image.setImageResource(android.R.color.transparent);;
        this.img.recycle();

    }


    private boolean checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            return false;
        }
        return true;
    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA},
                PERMISSION_REQUEST_CODE);
        if(checkPermission())
            openCamera();
        else
            Toast.makeText(this, "Vous devez autoriser l'accée a la caméra pour utiliser cette fonctionalité", Toast.LENGTH_SHORT).show();
    }

    private void openCamera() {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, CAMERA_REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(requestCode == CAMERA_REQUEST_CODE){
            img = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(img);
        }
    }
}
