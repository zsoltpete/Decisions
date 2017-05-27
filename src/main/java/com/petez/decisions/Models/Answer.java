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

/**
 * Represent answers.
 * @author petez
 */
public class Answer {
    
    private SimpleStringProperty answer;
    private double coinValue;
    private double businessValue;
    private double peopleValue;
    private double funValue;

    /**
     * Constructs a new Answer attribute with the given answer, coinValue, businessValue, peopleVale, funValue.
     * @param answer Answer name
     * @param coinValue Change of the coin value
     * @param businessValue Change of the business value
     * @param peopleValue Change of the people value
     * @param funValue Change of the fun value
     */
    public Answer(String answer, double coinValue, double businessValue, double peopleValue, double funValue) {
        this.answer = new SimpleStringProperty( answer);
        this.coinValue = coinValue;
        this.businessValue = businessValue;
        this.peopleValue = peopleValue;
        this.funValue = funValue;
    }

    /**
     * Returns answer name.
     * @return answer name
     */
    public SimpleStringProperty getAnswer() {
        return answer;
    }

    /**
     * Returns value change of coin.
     * @return coin change
     */
    public double getCoinValue() {
        return coinValue;
    }

    /**
     * Returns value change of business.
     * @return business change
     */
    public double getBusinessValue() {
        return businessValue;
    }

    /**
     * Returns value change of people.
     * @return people change
     */
    public double getPeopleValue() {
        return peopleValue;
    }

    /**
     * Returns value change of fun.
     * @return fun change
     */
    public double getFunValue() {
        return funValue;
    }

    /**
     * Set answer name.
     * @param answer answer name.
     */
    public void setAnswer(SimpleStringProperty answer) {
        this.answer = answer;
    }

    /**
     * Set coin change.
     * @param coinValue coin changing
     */
    public void setCoinValue(double coinValue) {
        this.coinValue = coinValue;
    }

    /**
     * Set business change.
     * @param businessValue business changing
     */
    public void setBusinessValue(double businessValue) {
        this.businessValue = businessValue;
    }

    /**
     * Set people change.
     * @param peopleValue people changing
     */
    public void setPeopleValue(double peopleValue) {
        this.peopleValue = peopleValue;
    }

    /**
     * Set fun change.
     * @param funValue fun changing
     */
    public void setFunValue(double funValue) {
        this.funValue = funValue;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Answer{" + "answer=" + answer + ", coinValue=" + coinValue + ", businessValue=" + businessValue + ", peopleValue=" + peopleValue + ", funValue=" + funValue + '}';
    }
    
    
    
}
