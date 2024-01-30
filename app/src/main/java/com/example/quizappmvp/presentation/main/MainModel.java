package com.example.quizappmvp.presentation.main;

import com.example.quizappmvp.data.model.QuestionData;
import com.example.quizappmvp.domain.AppController;

import java.util.List;

public class MainModel implements  MainContract.Model {
    private AppController controller = AppController.getInstance();

    @Override
    public List<QuestionData> getQuestionCategory() {
        return controller.getQuestionByCategory();
    }
}
