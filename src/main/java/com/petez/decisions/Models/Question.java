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

import java.util.List;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Represent Questions.
 * Question will be displayed to the user.
 * @author petez
 */
public class Question {
    
    private int id;
    private SimpleStringProperty name;
    private List<Answer> answers;
    
    /**
     * Constructs a new Question attribute with the given id,name and answers.
     * @param id question id
     * @param name question name
     * @param answers answers to the questions
     */
    public Question(int id, String name, List<Answer> answers) {
        this.id = id;
        this.name = new SimpleStringProperty( name);
        this.answers = answers;
    }

    /**
     * Returns question id.
     * @return question id.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns question name.
     * @return question name.
     */
    public SimpleStringProperty getName() {
        return name;
    }

    /**
     * Returns answers to the questions.
     * @return answers to the questions.
     */
    public List<Answer> getAnswers() {
        return answers;
    }
    
    /**
     * Set question id.
     * @param  question id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set question name.
     * @param  question name.
     */
    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    /**
     * Set question answers.
     * @param  answers to the questions.
     */
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", name=" + name + ", answers=" + answers + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.answers);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.answers, other.answers)) {
            return false;
        }
        return true;
    }
    
    
}
