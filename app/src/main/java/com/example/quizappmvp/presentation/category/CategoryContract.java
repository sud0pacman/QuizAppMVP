package com.example.quizappmvp.presentation.category;

import com.example.quizappmvp.data.model.CategoryEnum;

public interface CategoryContract {

    interface Model {
        void selectCategory(CategoryEnum categoryName);
    }

    interface View {
        void openQuestionActivity();
    }

    interface Presenter {
        void setSelectCategory(CategoryEnum category);
    }
}
