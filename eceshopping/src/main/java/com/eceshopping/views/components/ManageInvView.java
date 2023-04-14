package com.eceshopping.views.components;

import com.eceshopping.views.View;

import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;

public class ManageInvView extends GridPane implements View {
    
        private Hyperlink addArticleButton;
        private Hyperlink removeArticleButton;
        private Hyperlink modifyArticleButton;
        
        public ManageInvView() {
            super();
            this.addArticleButton = new Hyperlink("Add Article");
            this.removeArticleButton = new Hyperlink("Remove Article");
            this.modifyArticleButton = new Hyperlink("Modify Article");
            
            this.add(this.addArticleButton, 0, 0);
            this.add(this.removeArticleButton, 0, 1);
            this.add(this.modifyArticleButton, 0, 2);
        }
        
        public Hyperlink getAddArticleButton() {
            return this.addArticleButton;
        }
        
        public Hyperlink getRemoveArticleButton() {
            return this.removeArticleButton;
        }
        
        public Hyperlink getModifyArticleButton() {
            return this.modifyArticleButton;
        }

        @Override
        public Node getRootNode() {
            // TODO Auto-generated method stub
            return this;
        }

    
    
}
