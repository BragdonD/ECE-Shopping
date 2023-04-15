package com.eceshopping.controllers;

import com.eceshopping.services.ArticleService;
import com.eceshopping.views.ModifyArticleFormView;

public class ModifyArticleController {
 private ModifyArticleFormView view;
 ArticleService articleService = new ArticleService();
    
    public ModifyArticleController(ModifyArticleFormView view) throws IllegalArgumentException {
        this.view = view;
    }
   
} 
