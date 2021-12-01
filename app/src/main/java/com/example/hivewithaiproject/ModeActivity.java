package com.example.hivewithaiproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ModeActivity extends AppCompatActivity {
    CanvasActivity drawView;

//    EasyAICanvasActivity drawViewEasyAI;
//    NormalAICanvasActivity drawViewNormalAI;
//    HardAICanvasActivity drawViewHardAI;
    Button btnEasy, btnMedium, btnHard;
    public int depth;
    public boolean fiture_alphabeta;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode_game);
        btnEasy=findViewById(R.id.btnEasy);
        // vs player dulu
        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.board_game);
//                drawView = new CanvasActivity(this, 0, false);
//                setContentView(drawView);
                depth = 0;
                fiture_alphabeta = false;
                DrawBoard();
            }
        });
        btnMedium=findViewById(R.id.btnMedium);
        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                depth = 2;
                fiture_alphabeta = true;
                DrawBoardWithEasyAI(depth, fiture_alphabeta);
//                drawView = new CanvasActivity(this);
//                setContentView(drawView);
            }
        });
        btnHard=findViewById(R.id.btnHard);
        btnHard.setOnClickListener(new View.OnClickListener() { // sementara mode normal untuk testcanvas
            @Override
            public void onClick(View v) {
                depth = 4;
                fiture_alphabeta = true;
                DrawBoardWithNormalAI(depth, fiture_alphabeta);
            }
        });
    }

    private void DrawBoard() {
        drawView = new CanvasActivity(this);
        drawView.setData(new Bundle());
        setContentView(drawView);
    }

    private void DrawBoardWithEasyAI(int depth, boolean fiture) {
//        drawViewEasyAI = new EasyAICanvasActivity(this);
//        drawViewEasyAI.setData(new Bundle());
//        setContentView(drawViewEasyAI);
    }

    private void DrawBoardWithNormalAI(int depth, boolean fiture) {
//        drawViewNormalAI = new NormalAICanvasActivity(this);
//        drawViewNormalAI.setData(new Bundle());
//        setContentView(drawViewNormalAI);

//        TestCanvasActivity draw = new TestCanvasActivity(this);
//        draw.setData(new Bundle());
//        setContentView(draw);
    }

    private void DrawBoardWithHardAI(int depth, boolean fiture) {
//        drawViewHardAI = new HardAICanvasActivity(this);
//        drawViewHardAI.setData(new Bundle());
//        setContentView(drawViewHardAI);
    }

}
