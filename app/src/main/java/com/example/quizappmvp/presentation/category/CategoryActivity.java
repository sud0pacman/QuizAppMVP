package com.example.quizappmvp.presentation.category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.quizappmvp.R;
import com.example.quizappmvp.data.model.CategoryEnum;
import com.example.quizappmvp.presentation.main.MainActivity;

public class CategoryActivity extends AppCompatActivity implements  CategoryContract.View{
    private CategoryContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        presenter = new CategoryPresenter(this);
        initViews();
    }

    private void initViews() {
        findViewById(R.id.buttonGeography).setOnClickListener(v -> {
            presenter.setSelectCategory(CategoryEnum.GEOGRAFIYA);
        });

        findViewById(R.id.buttonHistory).setOnClickListener(v -> {
            presenter.setSelectCategory(CategoryEnum.TARIX);
        });

        findViewById(R.id.buttonPhysics).setOnClickListener(v -> {
            presenter.setSelectCategory(CategoryEnum.FIZIKA);
        });

        findViewById(R.id.buttonMath).setOnClickListener(v -> {
            presenter.setSelectCategory(CategoryEnum.TARIX);
        });
    }

    @Override
    public void openQuestionActivity() {
        Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
        startActivity(intent);
    }
}