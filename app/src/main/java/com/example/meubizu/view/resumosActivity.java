package com.example.meubizu.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.meubizu.R;
import com.example.meubizu.banco.ResumosDAO;
import com.example.meubizu.model.Resumo;

import java.util.ArrayList;

public class resumosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumos);
    }

}
