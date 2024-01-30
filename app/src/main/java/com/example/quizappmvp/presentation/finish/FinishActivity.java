package com.example.quizappmvp.presentation.finish;

import static android.content.Intent.getIntent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.quizappmvp.R;
import com.example.quizappmvp.presentation.main.MainActivity;

public class FinishActivity extends AppCompatActivity {

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finsh);

        int trueAns = getIntent().getIntExtra("CORRECTS", 0);
        int wrongAns = getIntent().getIntExtra("WRONGS", 0);

        TextView tvTrues = findViewById(R.id.tv_corrects);
        TextView tvWrongs = findViewById(R.id.tv_wrongs);

        tvTrues.setText("To'g'rilar: " + trueAns);
        tvWrongs.setText("Noto'g'rilar: " + wrongAns);

        AppCompatImageView back = findViewById(R.id.ic_back);
        AppCompatImageView reload = findViewById(R.id.ic_reload);

        back.setOnClickListener(v -> {
            finish();
        });


        reload.setOnClickListener(v -> {
            Intent main = new Intent(FinishActivity.this, MainActivity.class);
            startActivity(main);
            finish();
        });
    }
}