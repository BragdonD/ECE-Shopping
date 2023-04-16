package com.eceshopping.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
@NamedQueries({
        @NamedQuery(name = "BasketModel.findById", query = "FROM BasketModel WHERE id = :id"),
        @NamedQuery(name = "BasketModel.findByUserId", query = "FROM BasketModel WHERE user.id = :userId"),
        @NamedQuery(name = "BasketModel.findAll", query = "FROM BasketModel"),
})
public class BasketModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @OneToOne
        @JoinColumn(name = "user_id")
        private UserModel user;
        

        public BasketModel() {
        }

        public BasketModel(Integer id, UserModel user) {
                this.id = id;
                this.user = user;
        }

        public Integer getId() {
                return this.id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public UserModel getUser() {
                return this.user;
        }

        public void setUser(UserModel user) {
                this.user = user;
        }

        public BasketModel id(Integer id) {
                setId(id);
                return this;
        }

        public BasketModel user(UserModel user) {
                setUser(user);
                return this;
        }        
}
