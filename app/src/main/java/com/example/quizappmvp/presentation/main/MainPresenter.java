package com.example.quizappmvp.presentation.main;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizappmvp.data.model.QuestionData;
import com.example.quizappmvp.presentation.finish.FinishActivity;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.Model model;
    private List<QuestionData> questionList;
    private MainContract.View view;            // view bu interface
    private int currentPos = 0;
    private int selectIndex = -1;
    private int correctCount = 0;
    private int wrongCount = 0;

    public MainPresenter(MainContract.View view) {
        this.model = new MainModel();
        this.view = view;

        Log.d("TTT", "MainPresenter");

        view.levelUp(currentPos + 1, (currentPos + 1) * 10);
        view.nextButtonSate(false);

        loadQuestionData();
        loadQuestionDataByPos();
    }

    private void loadQuestionData() {
        this.questionList = model.getQuestionCategory();  // bu question listni initalizatsiya qiladi
    }

    private void loadQuestionDataByPos() {
        Log.d("TTT", "loadQuestionDataByPos " + questionList.get(currentPos).toString());
        view.describeQuestion(questionList.get(currentPos));   // bu har bir savolni positsiya bo'yich aolib beradi
    }

    @Override
    public void selectAnswer(int pos) {
        if (pos == this.selectIndex) return;
        if (selectIndex > -1)
            view.clearOldState(selectIndex); // agar variant birinchi marta tanlanmayotgan bo'lsa uncheck image qo'yiladi
        selectIndex = pos;
        view.showSelectIndex(pos);  // belgilangan variantni image bilan belgilab qo'yish
        view.nextButtonSate(true);
    }

    @Override
    public void clickNextButton() {
        if (currentPos >= questionList.size()) return;
        QuestionData currQuestion = questionList.get(currentPos);

        if (currQuestion.getAnswer().equals(currQuestion.getVariants()[selectIndex])) {
            ++correctCount;
        } else ++wrongCount;

        view.clearOldState(selectIndex);
        view.nextButtonSate(false);
        ++currentPos;

        if (currentPos >= questionList.size()) {
            view.showResult(correctCount, wrongCount);
            view.clickFinishButton();
        } else {
            view.describeQuestion(questionList.get(currentPos));
            selectIndex = -1;
            view.levelUp(currentPos + 1, (currentPos + 1) * 10);
        }
    }

    @Override
    public void clickFinishButton() {
        view.openFinishActivity(correctCount, wrongCount);
    }

    @Override
    public void clickCheckButton() {
        if (currentPos >= questionList.size()) return;
        QuestionData currQuestion = questionList.get(currentPos);

        boolean isCorrect = currQuestion.getAnswer().equals(currQuestion.getVariants()[selectIndex]);

        view.showNextDialog(isCorrect, currQuestion.getAnswer());
    }
}


























