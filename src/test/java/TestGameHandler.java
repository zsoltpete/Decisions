
import com.petez.decisions.Controllers.GameHandler;
import com.petez.decisions.Models.Answer;
import com.petez.decisions.Models.User;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import junit.framework.Assert;
import org.junit.Test;

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

/**
 *
 * @author petez
 */
public class TestGameHandler {
    
    public User getMockUser(){
        User user = new User(2, "Test", 0);
        return user;
    }
    
    public Answer getMockAnswer(){
        Answer answer = new Answer("Mi ez?", 0.1, 0.1, 0.1, 0.1);
        return answer;
    }
    /*
    @Test
    public void testGetBestResult(){
        GameHandler gameHandler = mock(GameHandler.class);
    }
   */ 
    @Test
    public void testInitSkills(){
        GameHandler gameHandler = new GameHandler();
        User user = getMockUser();
        List<DoubleProperty> doubleProperties = new ArrayList<DoubleProperty>();
        for(int i=0;i<4;i++){
            doubleProperties.add(new SimpleDoubleProperty(0.5));
        }
        
        user.setSkills(doubleProperties);
        Assert.assertEquals(gameHandler.initSkills(getMockUser()), user);
    }
    
    @Test
    public void testSendGameOver(){
        GameHandler gameHandler = new GameHandler();
        Assert.assertEquals(gameHandler.sendGameOver(getMockUser()), true);
    }
    @Test
    public void testSendedGameOver(){
        GameHandler gameHandler = new GameHandler();
        User user = getMockUser();
       for(int i=0;i<4;i++){
            user.getSkills().set(i, new SimpleDoubleProperty(0.5));
       }
        Assert.assertEquals(gameHandler.sendGameOver(user), false);
    }
    
    @Test
    public void updateAttributesWithAnswers(){
        GameHandler gameHandler = new GameHandler();
        Answer answer = getMockAnswer();
        User user = getMockUser();
        List<DoubleProperty> doubleProperties = new ArrayList<DoubleProperty>();
        for(int i=0;i<4;i++){
            doubleProperties.add(new SimpleDoubleProperty(0.1));
        }
        user.setSkills(doubleProperties);
        Assert.assertEquals(gameHandler.updateAttributesWithAnswers(getMockUser(), getMockAnswer()), user);
    }
    
    @Test
    public void testBestResult(){
        GameHandler gameHandler = new GameHandler();
        Assert.assertEquals(gameHandler.getBestResult(0), 0.0);
        
    }
    
    @Test
    public void testBestResultLessZero(){
        GameHandler gameHandler = new GameHandler();
        Assert.assertEquals(gameHandler.getBestResult(-1.0), 0.0);
        
    }
    
    @Test
    public void testBestResultGreaterZero(){
        GameHandler gameHandler = new GameHandler();
        Assert.assertEquals(gameHandler.getBestResult(2.0), 1.0);
        
    }
    
    @Test
    public void testUpdateCash(){
        GameHandler gameHandler = new GameHandler();
        User user = getMockUser();
        user.getCash().set("1");
        Assert.assertEquals(gameHandler.updateCash(getMockUser()), user);
    }
    
    @Test
    public void testUpdatePotion(){
        GameHandler gameHandler = new GameHandler();
        User user = getMockUser();
        
        double potionCount = 0.0;
        if(potionCount >=0){
            user.getSkills().set(0, new SimpleDoubleProperty(0.2+user.getSkills().get(0).getValue()));
            user.getPotions().set(0, new SimpleDoubleProperty(potionCount));
        }
        
        Assert.assertEquals(gameHandler.updatePotion(getMockUser(), 0), user);
    }
    
    
    
}
