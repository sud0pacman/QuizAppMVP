package com.example.quizappmvp.presentation.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.quizappmvp.R;
import com.example.quizappmvp.data.model.QuestionData;
import com.example.quizappmvp.presentation.finish.FinishActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private TextView textQuestion;
    private List<ViewGroup> groupsVariant;
    private List<ImageView> images;
    private List<TextView> texts;
    private Button btnNext;
    private Button btnFinish;
    private MainContract.Presenter presenter;
    private TextView tvLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        initViews();
        presenter = new MainPresenter(this);
    }

    private void initViews() {
        textQuestion = findViewById(R.id.text_question);
        btnNext = findViewById(R.id.btn_next);
        btnFinish = findViewById(R.id.btn_finish);

        images = new ArrayList<>();
        images.add(findViewById(R.id.image_variant_1));
        images.add(findViewById(R.id.image_variant_2));
        images.add(findViewById(R.id.image_variant_3));
        images.add(findViewById(R.id.image_variant_4));

        texts = new ArrayList<>();
        texts.add(findViewById(R.id.text_variant_1));
        texts.add(findViewById(R.id.text_variant_2));
        texts.add(findViewById(R.id.text_variant_3));
        texts.add(findViewById(R.id.text_variant_4));

        groupsVariant = new ArrayList<>();
        groupsVariant.add(findViewById(R.id.variant1));
        groupsVariant.add(findViewById(R.id.variant2));
        groupsVariant.add(findViewById(R.id.variant3));
        groupsVariant.add(findViewById(R.id.variant4));

        for (int i = 0; i < groupsVariant.size(); i++) {
            int index = i;
            groupsVariant.get(i).setOnClickListener(v -> {
                presenter.selectAnswer(index);
            });
        }

        btnNext.setOnClickListener(v -> clickNextButton());
        btnFinish.setOnClickListener(v -> clickFinishButton());

        tvLevel = findViewById(R.id.tv_level);
        tvLevel.setText("1/10");
    }

    @Override
    public void describeQuestion(QuestionData questionData) {
        textQuestion.setText(questionData.getQuestion());

        for (int i = 0; i < groupsVariant.size(); i++) {
            TextView variant = texts.get(i);

            variant.setText(questionData.getVariants()[i]);
        }
    }

    @Override
    public void showSelectIndex(int pos) {
        images.get(pos).setImageResource(R.drawable.ic_check);
    }


    @Override
    public void clearOldState(int pos) {
        images.get(pos).setImageResource(R.drawable.ic_unchecked);
    }

    @Override
    public void nextButtonSate(boolean bool) {
        btnNext.setEnabled(bool);
        btnNext.setBackgroundResource(R.drawable.bg_next_true_state);
    }

    @Override
    public void clickNextButton() {
        presenter.clickNextButton();
        btnNext.setBackgroundResource(R.drawable.bg_next);
    }

    @Override
    public void clickFinishButton() {
        presenter.clickFinishButton();
    }

    @Override
    public void openFinishActivity(int correctCount, int wrongCount) {
        Intent intent = new Intent(MainActivity.this, FinishActivity.class);
        intent.putExtra("CORRECTS", correctCount);
        intent.putExtra("WRONGS", wrongCount);
        startActivity(intent);
        finish();
    }

    @Override
    public void showResult(int correctCount, int wrongCount) {
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void levelUp(int currentPos) {
        tvLevel.setText(currentPos + "/10");
    }
}