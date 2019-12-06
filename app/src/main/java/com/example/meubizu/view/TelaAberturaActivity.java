package com.example.meubizu.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.example.meubizu.R;

public class TelaAberturaActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_abertura);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarMainActivity();
            }
        }, 4000);
    }

    private void mostrarMainActivity() {
        Intent intent = new Intent(
                TelaAberturaActivity.this, MainActivity.class
        );
        startActivity(intent);
        finish();
    }
}