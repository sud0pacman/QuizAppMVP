package com.example.quizappmvp.presentation.category;

import com.example.quizappmvp.data.model.CategoryEnum;
import com.example.quizappmvp.domain.AppController;

public class CategoryModel implements CategoryContract.Model {
    private AppController controller = AppController.getInstance();

    @Override
    public void selectCategory(CategoryEnum categoryName) {
        controller.setSelectCategory(categoryName);
    }
}
