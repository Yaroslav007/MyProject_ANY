package com.alwaysnearyou.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

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
    private Date time;
    private Integer user_id;

    @ManyToOne
    @JoinColumn(name = "message_roomId")
    private Room room;

    public Message(String textMessage, Date time, Integer user_id, Room room) {
        this.textMessage = textMessage;
        this.time = time;
        this.user_id = user_id;
        this.room = room;
    }
}
