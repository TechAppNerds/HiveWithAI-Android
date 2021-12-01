package com.example.hivewithaiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CanvasActivity drawView;
    Button btnNew, btnLoad, btnExit;
//    Drawable drawableBackground = context.getResources().getDrawable(R.drawable.black_king);;
    AssetManager assetManager;
    InputStream inputStream;
//    GridView gridView = null;
    ArrayList<Bitmap> bitmapList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        gridView = (GridView) findViewById(R.id.gridv)
        assetManager = getAssets();
        bitmapList = new ArrayList<Bitmap>();
        try {
            listAllImages();
        } catch (Exception e) {}
//        try {
//            listAllImages();
//        } catch (Exception e) {
//
//        }
//        inputStream = assetManager.open();
        //audioPlayer("");
//        Toast.makeText(getApplicationContext(),getIntent().getStringExtra("path"), Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(),"android.resource://"+getPackageName()+"/Audio/", Toast.LENGTH_SHORT).show();
        //Audio
        audioPlayer("android.resource://\"+getPackageName()+\"/Audio/","Karpov_Not_Kasparov_-_05_-_Deep_Fritz");
//        Toast.makeText(getApplicationContext(),getResources().openRawResource(R..lbpcascade_frontalface), Toast.LENGTH_SHORT).show();

//        btnNew=findViewById(R.id.btnNew);
//        btnLoad=findViewById(R.id.btnLoad);
//        btnExit=findViewById(R.id.btnExit);
//        btnNew.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Intent i = new Intent(getApplicationContext(),NextActivity.class);
//                //Intent i = new Intent(getBaseContext(), ModeActivity.class);
//                Intent i = new Intent(getApplicationContext(), ModeActivity.class);
//                startActivity(i);
//            }
//        });
//        btnLoad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),btnLoad.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        btnExit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//                System.exit(0);
//            }
//        });

//        drawView = new CanvasActivity(this);
//        drawView.setBackgroundColor(Color.WHITE);
//        setContentView(drawView);
    }

    public void listAllImages() {
        Bitmap bitmap = null;
        try {
            String[] imgPath = assetManager.list("Background");
            for (int i = 0; i < imgPath.length; i++) {
                InputStream is = assetManager.open("Background/" + imgPath[i]);
                Log.d("MainActivity", imgPath[i]);
                bitmap = BitmapFactory.decodeStream(is);
                bitmapList.add(bitmap);
            }
        } catch (IOException ex) {
            Log.e("MainActivity", ex.getMessage());
        }
    }

    public void audioPlayer(String path, String fileName){
        MediaPlayer mp = new MediaPlayer();
        try {
            mp.setDataSource(path+"/"+fileName);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mp.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.start();
    }

}