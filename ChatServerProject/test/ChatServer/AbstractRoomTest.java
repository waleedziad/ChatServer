/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChatServer;

import java.util.ArrayList;
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
public class AbstractRoomTest {
    
    public AbstractRoomTest() {
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
     * Test of setTitle method, of class AbstractRoom.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "Test Title";
        AbstractRoom instance = new AbstractRoom();
        instance.setTitle(title);
    }

    /**
     * Test of toString method, of class AbstractRoom.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AbstractRoom instance = new AbstractRoom();
        String title = "Test Title";
        instance.setTitle(title);
        int ID = 5;
        instance.setID(ID);
        AbstractUser user = new AbstractUser();
        user.setID(10);
        user.setName("Admin");
        instance.users.add(user);
        String expResult = "title: "+title+" id: "+ID;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class AbstractRoom.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        AbstractRoom instance = new AbstractRoom();
        String title = "Test Title";
        String expResult = title;
        instance.setTitle(title);
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDecription method, of class AbstractRoom.
     */
    @Test
    public void testSetDecription() {
        System.out.println("setDecription");
        String desc = "Test Description";
        AbstractRoom instance = new AbstractRoom();
        instance.setDecription(desc);
    }

    /**
     * Test of getDesciption method, of class AbstractRoom.
     */
    @Test
    public void testGetDesciption() {
        System.out.println("getDesciption");
        AbstractRoom instance = new AbstractRoom();
        String description = "Test Description";
        instance.setDecription(description);
        String expResult = description;
        String result = instance.getDesciption();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsers method, of class AbstractRoom.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        AbstractRoom instance = new AbstractRoom();
        AbstractUser user = new AbstractUser();
        user.setID(5);
        user.setName("Admin");
        instance.users.add(user);
        ArrayList<AbstractUser> expResult = new ArrayList();
        expResult.add(user);
        ArrayList<AbstractUser> result = instance.getUsers();
        assertEquals(expResult, result);
    }

    /**
     * Test of setID method, of class AbstractRoom.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int roomId = 5;
        AbstractRoom instance = new AbstractRoom();
        instance.setID(roomId);
    }

    /**
     * Test of getID method, of class AbstractRoom.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        AbstractRoom instance = new AbstractRoom();
        int ID = 5;
        instance.setID(ID);
        int expResult = ID;
        int result = instance.getID();
        assertEquals(expResult, result);
    }
    
}
