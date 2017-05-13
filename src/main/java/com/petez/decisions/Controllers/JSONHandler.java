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

import com.petez.decisions.Models.Question;
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
/**
 *
 * @author petez
 */
public class JSONHandler {
    
    public static void write(String location) throws IOException{
        
        JSONObject obj = new JSONObject();
		obj.put("Name", "crunchify.com");
		obj.put("Author", "App Shah");
 
		JSONArray company = new JSONArray();
		company.add("Compnay: eBay");
		company.add("Compnay: Paypal");
		company.add("Compnay: Google");
		obj.put("Company List", company);
 
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter(location)) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}
    
}
    
    public static List<Question> readQuestions(String location){
        JSONParser parser = new JSONParser();
        List<Question> questions = new ArrayList<Question>();
        try {
            
            Object obj = parser.parse(new FileReader(location));
            System.out.println(location);   
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            
            JSONArray questionJSonArray = (JSONArray) jsonObject.get("questions");
            Iterator<JSONObject> iterator = questionJSonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObjectIterator = (JSONObject) iterator.next();
                
            String id = (String) jsonObjectIterator.get("id");
            System.out.println(id);

            String name = (String) jsonObjectIterator.get("name");
            System.out.println(name);
            String answer1 = (String) jsonObjectIterator.get("answer1");
            System.out.println(answer1);
            String answer2 = (String) jsonObjectIterator.get("answer2");
            System.out.println(answer2);
            String coinValue = (String) jsonObjectIterator.get("coin_value");
            System.out.println(coinValue);
            String businessValue = (String) jsonObjectIterator.get("business_value");
            System.out.println(businessValue);
            String peopleValue = (String) jsonObjectIterator.get("people_value");
            System.out.println(peopleValue);
            String funValue = (String) jsonObjectIterator.get("fun_value");
            System.out.println(funValue);
            
            
            Question question = new Question(Integer.parseInt(id), name, answer1, answer2, Double.parseDouble(coinValue), Double.parseDouble(businessValue), Double.parseDouble(peopleValue), Double.parseDouble(funValue));
            System.out.println(question.getName().getValue());
            questions.add(question);
            
            }
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return questions;

    }
    
    
}
