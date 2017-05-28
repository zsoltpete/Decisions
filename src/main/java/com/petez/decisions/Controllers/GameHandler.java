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

import com.petez.decisions.Models.Answer;
import com.petez.decisions.Models.Question;
import com.petez.decisions.Models.User;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author petez
 */
public class GameHandler {
    /**
     * User skills check.
     * @param user  The actual user who play the game
     * @return false if user has no skills with 0 value true if one of the user skills is 0.
     */
    public boolean sendGameOver(User user){
        for(int i = 0;i<4;i++){
            if(user.getSkills().get(i).get() == 0){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Initialize skill and add a start value.
     * @param user  The actual user who play the game
     * @return Modified user with the initialized skills
     */
    public User initSkills(User user){
        user.getSkills().set(0, new SimpleDoubleProperty(0.5));
        user.getSkills().set(1, new SimpleDoubleProperty(0.5));
        user.getSkills().set(2, new SimpleDoubleProperty(0.5));
        user.getSkills().set(3, new SimpleDoubleProperty(0.5));
        return user;
    }
    
    /**
     * Update the user skills, with the actual answer.
     * It will change the user's attributes.
     * @param user The actual user who play the game
     * @param answer The answer, which belongs to the actual question
     * @return Modified user with modified skills 
     */
    public User updateAttributesWithAnswers(User user, Answer answer){
        
        user.getSkills().set(0, new SimpleDoubleProperty(getBestResult(answer.getCoinValue()+user.getSkills().get(0).getValue())));
        user.getSkills().set(1, new SimpleDoubleProperty(getBestResult(answer.getBusinessValue()+user.getSkills().get(1).getValue())));
        user.getSkills().set(2, new SimpleDoubleProperty(getBestResult(answer.getPeopleValue()+user.getSkills().get(2).getValue())));
        user.getSkills().set(3, new SimpleDoubleProperty(getBestResult(answer.getFunValue()+user.getSkills().get(3).getValue())));
        return user;
    }
    
        
    /**
     * Use to minimize or maximize skill point.
     * The skill point never be under 0 or between 1.
     * @param input Value what will be decide 0, 1 or actual value
     * @return a double value of input after decide
     */
    public double getBestResult(double input){
        if(input<0){
            return 0;
        }else if(input > 1){
            return 1;
        }else{
            return input;
        }
    }
    
        
    /**
     * Decide the user have one or more potion of the selected potion.
     * @param user  The actual user who play the game
     * @param selectedPotion Represent the selected potion index.
     * @return  The modified user with the modied potions
     */
    public User updatePotion(User user, int selectedPotion){
        Double potionCount = user.getPotions().get(selectedPotion).getValue()-1;
        if(potionCount >=0){
            user.getSkills().set(selectedPotion, new SimpleDoubleProperty(0.2+user.getSkills().get(selectedPotion).getValue()));
            user.getPotions().set(selectedPotion, new SimpleDoubleProperty(potionCount));
            
        }
        
        return user;
    }
    
    /**
     * Update the cash.
     * User get one coin for every year
     * @param user  The actual user who play the game
     * @return  The actual user who play the game
     */
    public User updateCash(User user){
        int cash = Integer.parseInt(user.getCash().get());
        user.getCash().set(String.valueOf(++cash));
        return user;
    }
}
