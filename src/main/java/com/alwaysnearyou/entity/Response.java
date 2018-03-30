package com.alwaysnearyou.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
public class Response {

    private String username;
    private String message;

    public Response(String username, String message) {
        this.username = username;
        this.message = message;
    }
}
