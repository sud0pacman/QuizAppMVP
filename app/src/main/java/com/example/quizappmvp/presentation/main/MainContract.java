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
        void clickFinishButton();
        void openFinishActivity(int correctCount, int wrongCount);
        void showResult(int correctCount, int wrongCount);
        void levelUp(int currentPos, int progress);

        void showNextDialog(boolean isCorrect, String trueAnswer);
    }

    interface Presenter {
        void selectAnswer(int pos);
        void clickNextButton();
        void clickFinishButton();
        void clickCheckButton();
    }
}
