package com.example.quizappmvp.presentation.category;

import com.example.quizappmvp.data.model.CategoryEnum;

public class CategoryPresenter implements CategoryContract.Presenter {
    CategoryContract.View view;
    CategoryContract.Model model;

    public CategoryPresenter(CategoryContract.View view) {
        this.view = view;
        model = new CategoryModel();
    }

    @Override
    public void setSelectCategory(CategoryEnum category) {
        model.selectCategory(category);
        view.openQuestionActivity();
    }
}