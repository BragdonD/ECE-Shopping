package com.eceshopping.controllers;

import java.util.List;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.services.ArticleService;
import com.eceshopping.views.ProductOverviewView;

import javafx.concurrent.Task;

public class ProductOverviewController implements Controller   {
    ArticleService articleService = new ArticleService();
    private ProductOverviewView view;

   public ProductOverviewController (ProductOverviewView view) throws IllegalArgumentException{

         this.view = view;
         this.articleService = new ArticleService();
         
   }


}
