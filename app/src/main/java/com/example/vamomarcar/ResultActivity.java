package com.example.vamomarcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent i = getIntent();
        int index = i.getIntExtra("index", 0);

        MainActivityViewModel vm = new ViewModelProvider(this).get(MainActivityViewModel.class);
        Event evento = vm.getEventos().get(index);

        ResultAdapter resultAdapter = new ResultAdapter(this,evento.getResult());
        RecyclerView rvresult = findViewById(R.id.rvResult);
        rvresult.setAdapter(resultAdapter);
        rvresult.setLayoutManager(new LinearLayoutManager(this));

        TextView tvMarcar = findViewById(R.id.tvMarcar);
        tvMarcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultActivity.this.finish();
            }
        });

        TextView tvClose = findViewById(R.id.tvClose);
        tvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultActivity.this.finish();
            }
        });


    }

}