package com.example.quizappmvp.presentation.main;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizappmvp.R;
import com.example.quizappmvp.data.model.QuestionData;
import com.example.quizappmvp.presentation.finish.FinishActivity;
import com.example.quizappmvp.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private TextView textQuestion;
    private List<ViewGroup> groupsVariant;
    private List<LinearLayout> outerCards;
    private List<LinearLayout> innerCards;
    private List<ImageView> images;
    private List<TextView> texts;
    private LinearLayout btnNext;
    private TextView btnNextInner;
    private TextView btnFinish;
    private MainContract.Presenter presenter;
    private ProgressBar progressBar;
    private TextView tvLevel;
    private ImageView btnCancel;
    private long startTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBarUtil.makeStatusBarTransparent(this);


        initViews();
        presenter = new MainPresenter(this);
        startTime = System.currentTimeMillis();
    }

    private void initViews() {
        textQuestion = findViewById(R.id.text_question);

        progressBar = findViewById(R.id.progressBar);
        tvLevel = findViewById(R.id.tv_level);

        btnNext = findViewById(R.id.btn_check);
        btnNextInner = findViewById(R.id.btn_check_inner);

        btnFinish = findViewById(R.id.btn_finish);
        btnCancel = findViewById(R.id.cacnelBtn);

        outerCards = new ArrayList<>();

        outerCards.add(findViewById(R.id.variant_out_card_1));
        outerCards.add(findViewById(R.id.variant_out_card_2));
        outerCards.add(findViewById(R.id.variant_out_card_3));
        outerCards.add(findViewById(R.id.variant_out_card_4));

        innerCards = new ArrayList<>();
        innerCards.add(findViewById(R.id.variant1));
        innerCards.add(findViewById(R.id.variant2));
        innerCards.add(findViewById(R.id.variant3));
        innerCards.add(findViewById(R.id.variant4));


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

        btnCancel.setOnClickListener(v -> {
            exitBottomDialog();
        });

        btnNext.setOnClickListener(v -> clickCheckButton());
        btnFinish.setOnClickListener(v -> clickFinishButton());
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
        outerCards.get(pos).setBackgroundResource(R.drawable.bg_out_variant_select);
        innerCards.get(pos).setBackgroundResource(R.drawable.bg_inner_variant_select);
    }


    @Override
    public void clearOldState(int pos) {
        images.get(pos).setImageResource(R.drawable.ic_unchecked);
        outerCards.get(pos).setBackgroundResource(R.drawable.bg_out_variant);
        innerCards.get(pos).setBackgroundResource(R.drawable.bg_inner_variant);
    }

    @Override
    public void nextButtonSate(boolean bool) {
        btnNext.setEnabled(bool);

        if (bool) {
            btnNextInner.setBackgroundResource(R.drawable.blue_inner);
            btnNext.setBackgroundResource(R.drawable.blue_out);
        } else {
            btnNextInner.setBackgroundResource(R.drawable.bg_next_false_state);
            btnNext.setBackgroundResource(R.drawable.bg_next_false_state);
        }
    }


    private void clickCheckButton() {
        presenter.clickCheckButton();
        nextButtonSate(false);
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
        intent.putExtra("TIME", System.currentTimeMillis() - startTime);
        startActivity(intent);
        finish();
    }

    @Override
    public void showResult(int correctCount, int wrongCount) {
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void levelUp(int level, int progress) {
        progressBar.setProgress(progress);
        tvLevel.setText("" + level);
    }


    private void exitBottomDialog() {
        Dialog bottomDialog = new Dialog(this);
        bottomDialog.setContentView(R.layout.dialog_exit);

        Objects.requireNonNull(bottomDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        bottomDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Objects.requireNonNull(bottomDialog.getWindow()).getAttributes().windowAnimations = R.style.DialogAnimation;
        Objects.requireNonNull(bottomDialog.getWindow()).setGravity(Gravity.BOTTOM);

        bottomDialog.getWindow().findViewById(R.id.home_section).setOnClickListener(v -> {
            finish();
        });


        bottomDialog.getWindow().findViewById(R.id.continue_section).setOnClickListener(v -> {
            bottomDialog.cancel();
        });

        bottomDialog.show();
    }

    @Override
    public void showNextDialog(boolean isCorrect, String trueAnswer) {
        Dialog nextDialog = new Dialog(this);

        if (isCorrect) {
            nextDialog.setContentView(R.layout.dialog_next_green);
        } else {
            nextDialog.setContentView(R.layout.dialog_next_red);

            TextView answer = Objects.requireNonNull(nextDialog.getWindow()).findViewById(R.id.trueAnswerTv);

            answer.setText(trueAnswer);
        }

        Objects.requireNonNull(nextDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        nextDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Objects.requireNonNull(nextDialog.getWindow()).getAttributes().windowAnimations = R.style.DialogAnimation;
        Objects.requireNonNull(nextDialog.getWindow()).setGravity(Gravity.BOTTOM);
        nextDialog.setCancelable(false);


        nextDialog.getWindow().findViewById(R.id.btn_next).setOnClickListener(v -> {
            presenter.clickNextButton();
            nextDialog.cancel();
        });


        nextDialog.show();
    }

    @Override
    public void onBackPressed() {

        // To execute back press
        // super.onBackPressed()

        // To do something else
    }
}