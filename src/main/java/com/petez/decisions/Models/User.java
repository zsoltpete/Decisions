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
package com.petez.decisions.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *  Representing @{User} class.
 * @author petez
 */
public class User {
    
    private int id;
    private String name;
    private StringProperty cash = new SimpleStringProperty();
    private List<DoubleProperty> skills;
    private List<StringProperty> potions;

    /**
     * Constructor of the @{User} class
     * @param id Show the user id, which is an unique value.
     * @param name Show user name.
     * @param cash Represent user cash. This important to buy @{Potion}
     */
    public User(int id, String name, int cash) {
        DoubleProperty[] doubles = new DoubleProperty[4];
        Arrays.fill(doubles,new SimpleDoubleProperty(0.5));
        skills = Arrays.asList(doubles);
        
        StringProperty[] strings = new StringProperty[4];
        Arrays.fill(strings,new SimpleStringProperty("5"));
        potions = Arrays.asList(strings);
        
        this.id = id;
        this.name = name;
        this.cash.setValue(String.valueOf(cash));
    }

    /**
     * Returns user's id.
     * @return user's id.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns user's name.
     * @return user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns user's cash.
     * @return user's cash.
     */
    public StringProperty getCash() {
        return cash;
    }

    /**
     * Returns user's id.
     * @return user's id.
     */
    public List<DoubleProperty> getSkills() {
        return skills;
    }
    
    /**
     * Returns user's potions.
     * @return user's potions.
     */
    public List<StringProperty> getPotions() {
        return potions;
    }
    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", cash=" + cash + '}';
    }

    /**
     * Set user's id.
     * @param  user's id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set user's name.
     * @param  user's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set user's cash.
     * @param  user's cash.
     */
    public void setCash(int cash) {
        this.cash.setValue(String.valueOf(cash));
    }

    /**
     * Set user's id.
     * @param  user's id.
     */
    public void setCash(StringProperty cash) {
        this.cash = cash;
    }

    /**
     * Set user's skills.
     * @param  user's skills.
     */
    public void setSkills(List<DoubleProperty> skills) {
        this.skills = skills;
    }

    /**
     * Set user's skills.
     * @param  user's skills.
     */
    public void setPotions(List<StringProperty> potions) {
        this.potions = potions;
    }

    

    
    
    
}
