package com.alwaysnearyou.controller;


import com.alwaysnearyou.service.RoomService;
import com.alwaysnearyou.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/chat")
public class Chat {

    static Set<Session> chatroomUsers = Collections.synchronizedSet( new HashSet<Session>());

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @OnOpen
    public void handleOpen(Session userSession){
        chatroomUsers.add(userSession);
//        Integer userId = (Integer) session.getAttribute("user");
//        User userById = userService.findUserById(userId);
//        String str = userById.getName() + " " + userById.getSurname();
//        userSession.getUserProperties().put("fullname",str);
//        sessionMap.put(userId,userSession);

        System.out.println("Connectin is created");
    }

    @OnMessage
    public void   handleMessage(String message, Session userSession) throws IOException {
//        String[] subStr;
//        String delimeter = "\\\"";
//        subStr = message.split(delimeter);
//        int a1 = subStr.length - 5;
//        String a = subStr[a1];
//        Integer roomId = Integer.valueOf(a.substring(1, a.length() - 1));
//        System.out.println(roomId);
//        int a2 = subStr.length - 2;
//        String messageText = subStr[a2];
//
//        Room roomById = roomService.findRoomById(roomId);
//        List<User> usersInRoom = roomById.getUsersInRoom();
//        List<Session> sessionsInRoom;
//        for (User u:usersInRoom) {
//            Session session = sessionMap.get(u);
//            String fullname = (String) session.getUserProperties().get("fullname");
//            session.getBasicRemote().sendText(buildJsonData(fullname,message));
//        }

//        String username =(String) userSession.getUserProperties().get("username");
//        if(username==null){
//            userSession.getUserProperties().put("username",message);
//            userSession.getBasicRemote().sendText(buildJsonData("System","you are now connected as "+message));
//        }else{
//            Iterator<Session> itarator = chatroomUsers.iterator();
//            while (itarator.hasNext()) itarator.next().getBasicRemote().sendText(buildJsonData(username,message));
//        }


        System.out.print("message from Client = " + message);
        String replyMessage = "echo" + message;
        System.out.print("message send to Client = " + replyMessage);
    }

    @OnClose
    public void handleClose(Session userSession){
//        Integer userId = (Integer) session.getAttribute("user");
//        sessionMap.remove(userId);
        chatroomUsers.remove(userSession);

        System.out.println("Connection is closed");
    }

    @OnError
    public void onError(Session session, Throwable thr) {}

    private String buildJsonData(String username, String message)  {
//        throws JsonProcessingException
//        Response response = new Response(username, message);
//        return mapper.writeValueAsString(response);
        JsonObject jsonObject = Json.createObjectBuilder().add("message", username+": "+message).build();
        StringWriter stringWriter = new StringWriter();
        try(JsonWriter jsonWriter = Json.createWriter(stringWriter)){
            jsonWriter.write(jsonObject);
        }
        return stringWriter.toString();
    }

    public Chat() {
    }
}
