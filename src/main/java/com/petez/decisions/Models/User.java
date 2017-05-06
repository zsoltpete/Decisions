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
 *
 * @author petez
 */
public class User {
    
    private int id;
    private String name;
    private StringProperty cash = new SimpleStringProperty();
    private List<DoubleProperty> skills;
    private List<StringProperty> potions;

    /**
     *
     * @param id
     * @param name
     * @param cash
     */
    public User(int id, String name, int cash) {
        DoubleProperty[] doubles = new DoubleProperty[4];
        Arrays.fill(doubles,new SimpleDoubleProperty(1));
        skills = Arrays.asList(doubles);
        
        StringProperty[] strings = new StringProperty[4];
        Arrays.fill(strings,new SimpleStringProperty("2"));
        potions = Arrays.asList(strings);
        
        this.id = id;
        this.name = name;
        this.cash.setValue(String.valueOf(cash));
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public StringProperty getCash() {
        return cash;
    }

    /**
     *
     * @return
     */
    public List<DoubleProperty> getSkills() {
        return skills;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", cash=" + cash + '}';
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param cash
     */
    public void setCash(int cash) {
        this.cash.setValue(String.valueOf(cash));
    }

    /**
     *
     * @param cash
     */
    public void setCash(StringProperty cash) {
        this.cash = cash;
    }

    /**
     *
     * @param skills
     */
    public void setSkills(List<DoubleProperty> skills) {
        this.skills = skills;
    }

    public void setPotions(List<StringProperty> potions) {
        this.potions = potions;
    }

    public List<StringProperty> getPotions() {
        return potions;
    }

    
    
    
}
