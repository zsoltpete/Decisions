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

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author petez
 */
public class Question {
    
    private int id;
    private SimpleStringProperty name;
    private SimpleStringProperty answer1;
    private SimpleStringProperty answer2;
    private double coinValue;
    private double businessValue;
    private double peopleValue;
    private double funValue;

    public Question(int id, String name, String answer1, String answer2, double coinValue, double businessValue, double peopleValue, double funValue) {
        this.id = id;
        this.name = new SimpleStringProperty( name);
        this.answer1 = new SimpleStringProperty(answer1);
        this.answer2 = new SimpleStringProperty(answer2);
        this.coinValue = coinValue;
        this.businessValue = businessValue;
        this.peopleValue = peopleValue;
        this.funValue = funValue;
    }

    public int getId() {
        return id;
    }

    public double getCoinValue() {
        return coinValue;
    }

    public double getBusinessValue() {
        return businessValue;
    }

    public double getPeopleValue() {
        return peopleValue;
    }

    public double getFunValue() {
        return funValue;
    }

    public SimpleStringProperty getName() {
        return name;
    }

    public SimpleStringProperty getAnswer1() {
        return answer1;
    }

    public SimpleStringProperty getAnswer2() {
        return answer2;
    }


    

    

    public void setId(int id) {
        this.id = id;
    }

    public void setCoinValue(double coinValue) {
        this.coinValue = coinValue;
    }

    public void setBusinessValue(double businessValue) {
        this.businessValue = businessValue;
    }

    public void setPeopleValue(double peopleValue) {
        this.peopleValue = peopleValue;
    }

    public void setFunValue(double funValue) {
        this.funValue = funValue;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public void setAnswer1(SimpleStringProperty answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(SimpleStringProperty answer2) {
        this.answer2 = answer2;
    }

    
    
    
    
}
