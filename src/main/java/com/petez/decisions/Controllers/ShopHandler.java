/*
 * The MIT License
 *
 * Copyright 2017 Zsolt Pete.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.petez.decisions.Controllers;

import com.petez.decisions.Models.User;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author petez
 */
public class ShopHandler {
    
    /**
     * Update user cash property. 
     * @param cash Actual value of user's cash
     * @param value Represent how much what the user spend on potions.
     * @return cash integer value after buy potion
     */
        public int updateUserCash(int cash, int value){
        cash = cash-value;
        return cash;
    }
        
    /**
     * Increment by one the indexed potion.
     * Increment the indexed potion by one and change the user with this modified value
     * @param user  The actual user who play the game
     * @param potionIndex Selected potion index
     * @return The modified user with modified potion
     */
    public User incrementPotion(User user, int potionIndex){
            User changedUser = user;
            System.out.println("Buy something");
            double potionCounter = user.getPotions().get(potionIndex).get();
            changedUser.getPotions().set(potionIndex, new SimpleDoubleProperty(++potionCounter));
            
            return user;
        }
        
    /**
     * Checking the user can buy any of the potions.
     * @param value Represent user cash
     * @return True if user have enough money to buy potion otherwise false
     */
    public Boolean userCanBuy(int value){
            if(value>=10){
                return false;
            }
            
            return true;
        }
    
}
