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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Class for handling JSON objects.
 * @author petez
 */
public class JSONHandler {
    
    private static Logger logger = LoggerFactory.getLogger(JSONHandler.class);
    
    /**
     * Read JSON objects and create a List of Questions
     * @param location Use to  locate JSON object file.
     * @return A List with Question objects.
     */
    public static List<Question> readQuestions(String location){
        JSONParser parser = new JSONParser();
        List<Question> questions = new ArrayList<Question>();
        try {
            
            Object obj = parser.parse(new FileReader(location));
            JSONObject jsonObject = (JSONObject) obj;
            logger.debug(jsonObject.toJSONString());
            
            JSONArray questionJSonArray = (JSONArray) jsonObject.get("questions");
            Iterator<JSONObject> iterator = questionJSonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObjectIterator = (JSONObject) iterator.next();
                
            String id = (String) jsonObjectIterator.get("id");
            logger.debug(id);

            String name = (String) jsonObjectIterator.get("name");
            logger.debug(name);
            
            JSONArray answersJSonArray = (JSONArray) jsonObjectIterator.get("answers");
            Iterator<JSONObject> answersJSonIterator = answersJSonArray.iterator();
            
            List<Answer> answers = new ArrayList<Answer>();
            
            while (answersJSonIterator.hasNext()) {
                JSONObject jsonAnswerObject = (JSONObject) answersJSonIterator.next();
                String answerTitle = (String) jsonAnswerObject.get("answer");
                String coinValue = (String) jsonAnswerObject.get("coin_value");
                String businessValue = (String) jsonAnswerObject.get("business_value");
                String peopleValue = (String) jsonAnswerObject.get("people_value");
                String funValue = (String) jsonAnswerObject.get("fun_value");
                Answer answer = new Answer(answerTitle, Double.parseDouble(coinValue), Double.parseDouble(businessValue), Double.parseDouble(peopleValue), Double.parseDouble(funValue));
                answers.add(answer);
                logger.debug(answer.toString());
            }
            Question question = new Question(Integer.parseInt(id), name,answers);
            logger.debug(question.toString());
            questions.add(question);
            }
            

        } catch (FileNotFoundException e) {
            logger.error(e.toString());
            //e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.toString());
            //e.printStackTrace();
        } catch (ParseException e) {
            logger.error(e.toString());
            //e.printStackTrace();
        }
        return questions;

    }
    
    /**
     * Write a JSON file at the location with the given points
     * @param points Points of the last play
     * @param location Location of the new file, where create the last point JSON
     */
    public static void lastScoreWrite(Integer points, String location) {

        JSONObject obj = new JSONObject();
        obj.put("name", UserSettings.user.getName());
        obj.put("point", points);

        try (FileWriter file = new FileWriter(System.getProperty("user.home") + "/" +location)) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            logger.error(e.toString());
        }

        logger.info("Successful write last Score");

    }

    /**
     * Read of the JSON file from location and create an Integer from the value.
     * @param location Location of the file where stored the last play's point
     * @return Last play points which store in the JSON file
     */
    public static Integer lastScoreRead(String location){
    JSONParser parser = new JSONParser();
        double point = 0.0;
        try {

            Object obj = parser.parse(new FileReader(System.getProperty("user.home") + "/" + location));

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");

            point = (Long)jsonObject.get("point");

        } catch (FileNotFoundException e) {
            logger.error(e.toString());
            //e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.toString());
            //e.printStackTrace();
        } catch (ParseException e) {
            logger.error(e.toString());
            //e.printStackTrace();
        }
        return (int)point;
    }
    
    /**
     * Decide the location is exist or is not and returns the bool value
     * @param location Location of the searched file
     * @return Bool value of the existence of the location
     */
    public static Boolean isExistLastScore(String location){
        String path = System.getProperty("user.home") + "/" +location;
        logger.debug(path);
        File file = new File(path);
        if(file.exists() && !file.isDirectory()) { 
            logger.debug("true");
            return true;
        }
        logger.debug("false");
        return false;
        
    }
    
    /**
     * Create a folder at the location
     * @param location Location of the file what create 
     */
    public static void createFolder(String location){
        String path = System.getProperty("user.home") + "/" +location;
        File file = new File(path);
        file.mkdir();
    }
    
}
