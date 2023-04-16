package com.eceshopping.utils;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.dto.BasketDto;
import com.eceshopping.dto.BasketItemDto;
import com.eceshopping.dto.UserDto;
import com.eceshopping.utils.listeners.UserChangedListener;

/**
 * Session class is used to store the current user in memory.
 * @implNote This class is a singleton.
 * @implNote This class is not in its final state.
 */
public class Session {
    private UserDto user;
    private BasketDto basket;
    private List<UserChangedListener> userChangedListeners;
    private static Session instance;

    /**
     * Default constructor for the Session class.
     */
    private Session() {
        this.user = null;
        this.basket = new BasketDto();
        this.userChangedListeners = new ArrayList<UserChangedListener>();
    }

    /**
     * This method is used to get the instance of the Session class.
     * @return
     */
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public List<BasketItemDto> getItems() {
        return basket.getBasketItems();
    }

    /**
     * This method is used to get the current user in the session.
     * @return The current user in the session
     */
    public UserDto getUser() {
        return user;
    }

    /**
     * This method is used to set the current user in the session.
     * @param user The current user in the session
     */
    public void setUser(UserDto user) {
        this.user = user;
        notifyUserChangedListeners();
    }
    
    /**
     * This method is used to clear the current session for the future user.
     */
    public void clear() {
        this.user = null;
    }

    /**
     * This method is used to register an observer of user changes.
     * @param listener The observer to register
     */
    public void addUserChangedListener(UserChangedListener listener) {
        userChangedListeners.add(listener);
    }

    /**
     * This method is used to unregister an observer of user changes.
     * @param listener The observer to unregister
     */
    public void removeUserChangedListener(UserChangedListener listener) {
        userChangedListeners.remove(listener);
    }

    /**
     * This method is used to notify all observers of user changes.
     */
    private void notifyUserChangedListeners() {
        for (UserChangedListener listener : userChangedListeners) {
            listener.userChanged(user);
        }
    }

        /**
     * This method is used to set the current user in the session.
     * @param user The current user in the session
     * @return The current session
     */
    public Session user(UserDto user) {
        this.user = user;
        //this.basket = user.getBasket();
        notifyUserChangedListeners();
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " user='" + getUser() + "'" +
            "}";
    }

    public void addItemToCart(BasketItemDto basket) {
        this.basket.addItem(basket);
    }

    public void removeItemFromCart(BasketItemDto basket) {
        this.basket.removeItem(basket);
    }
}
