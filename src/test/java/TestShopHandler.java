
import com.petez.decisions.Controllers.ShopHandler;
import com.petez.decisions.Models.User;
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
public class TestShopHandler {
    
    public User getMockUser(){
        User user = new User(2, "Test", 0);
        return user;
    }
    
    @Test
    public void testupdateUserCash(){
        ShopHandler shopHandler = new ShopHandler();
        int value = shopHandler.updateUserCash(10,5);
        Assert.assertEquals(value, 10-5);
    }
    
    @Test
    public void testUserCanBuy(){
        ShopHandler shopHandler = new ShopHandler();
        boolean value = shopHandler.userCanBuy(0);
        Assert.assertEquals(value, true);
    }
    
    @Test
    public void testUserCanBuyTrue(){
        ShopHandler shopHandler = new ShopHandler();
        boolean value = shopHandler.userCanBuy(11);
        Assert.assertEquals(value, false);
    }
    
    @Test
    public void testIncreasePotion(){
        ShopHandler shopHandler = new ShopHandler();
        User user = getMockUser();
        user.getPotions().set(0, new SimpleDoubleProperty(2.0));
        
        boolean value = shopHandler.userCanBuy(0);
        Assert.assertEquals(shopHandler.incrementPotion(getMockUser(), 0), user);
    }
    
}
