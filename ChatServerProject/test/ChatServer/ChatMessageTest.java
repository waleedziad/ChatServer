/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChatServer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hady93
 */
public class ChatMessageTest {
    
    public ChatMessageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setSender method, of class ChatMessage.
     */
    @Test
    public void testSetSender() {
        System.out.println("setSender");
        AbstractUser user = null;
        ChatMessage instance = new ChatMessage();
        instance.setMessage("Testing Hello");
        instance.setSender(user);
    }

    /**
     * Test of getSender method, of class ChatMessage.
     */
    @Test
    public void testGetSender() {
        System.out.println("getSender");
        ChatMessage instance = new ChatMessage();
        AbstractUser user = new AbstractUser();
        user.setName("Admin");
        user.setID(1);
        instance.setSender(user);
        AbstractUser expResult = user;
        AbstractUser result = instance.getSender();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMessage method, of class ChatMessage.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String msg = "Testing Hello";
        ChatMessage instance = new ChatMessage();
        instance.setMessage("Testing Hello");
        instance.setMessage(msg);
    }

    /**
     * Test of getMessage method, of class ChatMessage.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        ChatMessage instance = new ChatMessage();
        instance.setMessage("Testing Hello");
        String expResult = "Testing Hello";
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ChatMessage.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ChatMessage instance = new ChatMessage();
        instance.setMessage("Testing Hello");
        AbstractUser user = new AbstractUser();
        user.setName("Admin");
        user.setID(1);
        instance.setSender(user);
        String expResult = "sender : Admin  message : Testing Hello";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
