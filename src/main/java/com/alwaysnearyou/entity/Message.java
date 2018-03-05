package com.alwaysnearyou.entity;

import lombok.*;

import javax.persistence.*;
import java.text.SimpleDateFormat;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String textMessage;
    private SimpleDateFormat time;
    private Integer user_id;

    @ManyToOne
    @JoinColumn(name = "message_roomId")
    private Room room;
}
