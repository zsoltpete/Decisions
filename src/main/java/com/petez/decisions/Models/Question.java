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

/**
 *
 * @author petez
 */
public class Question {
    
    private int id;
    private String name;
    private int coinValue;
    private int businessValue;
    private int peopleValue;
    private int funValue;

    public Question(int id, String name, int coinValue, int businessValue, int peopleValue, int funValue) {
        this.id = id;
        this.name = name;
        this.coinValue = coinValue;
        this.businessValue = businessValue;
        this.peopleValue = peopleValue;
        this.funValue = funValue;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCoinValue() {
        return coinValue;
    }

    public int getBusinessValue() {
        return businessValue;
    }

    public int getPeopleValue() {
        return peopleValue;
    }

    public int getFunValue() {
        return funValue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoinValue(int coinValue) {
        this.coinValue = coinValue;
    }

    public void setBusinessValue(int businessValue) {
        this.businessValue = businessValue;
    }

    public void setPeopleValue(int peopleValue) {
        this.peopleValue = peopleValue;
    }

    public void setFunValue(int funValue) {
        this.funValue = funValue;
    }
    
}
