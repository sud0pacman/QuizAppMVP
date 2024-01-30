package com.example.quizappmvp.presentation.main;

import com.example.quizappmvp.data.model.QuestionData;

import java.util.List;

public interface MainContract {
    interface Model {
        List<QuestionData> getQuestionCategory();  // savol qaytaradi
    }

    interface View {
        void describeQuestion(QuestionData questionData);
        void showSelectIndex(int pos);
        void clearOldState(int pos);
        void nextButtonSate(boolean bool);
        void clickNextButton();
        void clickFinishButton();
        void openFinishActivity(int correctCount, int wrongCount);
        void showResult(int correctCount, int wrongCount);
        void levelUp(int currentPos);

    }

    interface Presenter {
        void selectAnswer(int pos);
        void clickNextButton();
        void clickFinishButton();
    }
}
