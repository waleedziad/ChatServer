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
public class ChatServerTest {
    
    public ChatServerTest() {
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
     * Test of addUser method, of class ChatServer.
     */
    @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        GeneralUser user = null;
        ChatServer instance = null;
        instance.addUser(user);
    }

    /**
     * Test of addRoomAdmin method, of class ChatServer.
     */
    @Test
    public void testAddRoomAdmin() {
        System.out.println("addRoomAdmin");
        AdminUser admin = null;
        ArrayList permissions = null;
        ChatServer instance = null;
        instance.addRoomAdmin(admin, permissions);
    }

    /**
     * Test of removeUser method, of class ChatServer.
     */
    @Test
    public void testRemoveUser() throws Exception {
        System.out.println("removeUser");
        int userID = 0;
        ChatServer instance = null;
        instance.removeUser(userID);
    }

    /**
     * Test of removeAllUser method, of class ChatServer.
     */
    @Test
    public void testRemoveAllUser() {
        System.out.println("removeAllUser");
        int roomID = 0;
        ChatServer instance = null;
        instance.removeAllUser(roomID);
    }

    /**
     * Test of removeRoom method, of class ChatServer.
     */
    @Test
    public void testRemoveRoom() throws Exception {
        System.out.println("removeRoom");
        int roomID = 0;
        ChatServer instance = null;
        instance.removeRoom(roomID);
    }

    /**
     * Test of getRooms method, of class ChatServer.
     */
    @Test
    public void testGetRooms() {
        System.out.println("getRooms");
        ChatServer instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getRooms();
        assertEquals(expResult, result);
    }

    /**
     * Test of joinRoom method, of class ChatServer.
     */
    @Test
    public void testJoinRoom() throws Exception {
        System.out.println("joinRoom");
        int roomID = 0;
        int userID = 0;
        ChatServer instance = null;
        instance.joinRoom(roomID, userID);
    }

    /**
     * Test of removeAllRooms method, of class ChatServer.
     */
    @Test
    public void testRemoveAllRooms() {
        System.out.println("removeAllRooms");
        ArrayList rooms = null;
        ChatServer instance = null;
        instance.removeAllRooms(rooms);
    }

    /**
     * Test of createGenralRoom method, of class ChatServer.
     */
    @Test
    public void testCreateGenralRoom() throws Exception {
        System.out.println("createGenralRoom");
        String title = "";
        String desc = "";
        ArrayList allowdUsers = null;
        ChatServer instance = null;
        instance.createGenralRoom(title, desc, allowdUsers);
    }

    /**
     * Test of sendMessage method, of class ChatServer.
     */
    @Test
    public void testSendMessage() throws Exception {
        System.out.println("sendMessage");
        ChatMessage message = null;
        AbstractUser recipient = null;
        ChatServer instance = null;
        instance.sendMessage(message, recipient);
    }

    /**
     * Test of leaveRoom method, of class ChatServer.
     */
    @Test
    public void testLeaveRoom() {
        System.out.println("leaveRoom");
        int roomID = 0;
        int userID = 0;
        ChatServer instance = null;
        instance.leaveRoom(roomID, userID);
    }

    /**
     * Test of getInstance method, of class ChatServer.
     */
    @Test
    public void testGetInstance() throws Exception {
        System.out.println("getInstance");
        ChatServer expResult = null;
        ChatServer result = ChatServer.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of loadPersistanceConfigurations method, of class ChatServer.
     */
    @Test
    public void testLoadPersistanceConfigurations() {
        System.out.println("loadPersistanceConfigurations");
        ChatServer instance = null;
        instance.loadPersistanceConfigurations();
    }

    /**
     * Test of blockUser method, of class ChatServer.
     */
    @Test
    public void testBlockUser() {
        System.out.println("blockUser");
        int userID = 0;
        int blockedUserID = 0;
        ChatServer instance = null;
        instance.blockUser(userID, blockedUserID);
    }

    /**
     * Test of getRoom method, of class ChatServer.
     */
    @Test
    public void testGetRoom() throws Exception {
        System.out.println("getRoom");
        int roomID = 0;
        ChatServer instance = null;
        AbstractRoom expResult = null;
        AbstractRoom result = instance.getRoom(roomID);
        assertEquals(expResult, result);
    }

    /**
     * Test of creatRestirctedRoom method, of class ChatServer.
     */
    @Test
    public void testCreatRestirctedRoom() {
        System.out.println("creatRestirctedRoom");
        String title = "";
        String desc = "";
        ArrayList allowdUsers = null;
        ChatServer instance = null;
        instance.creatRestirctedRoom(title, desc, allowdUsers);
    }

    /**
     * Test of getUser method, of class ChatServer.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        int userID = 0;
        ChatServer instance = null;
        AbstractUser expResult = null;
        AbstractUser result = instance.getUser(userID);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseInput method, of class ChatServer.
     */
    @Test
    public void testParseInput() {
        System.out.println("parseInput");
        String input = "";
        ChatServer instance = null;
        String expResult = "";
        String result = instance.parseInput(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of listen method, of class ChatServer.
     */
    @Test
    public void testListen() {
        System.out.println("listen");
        int portNum = 0;
        ChatServer instance = null;
        instance.listen(portNum);
    }
    
}
