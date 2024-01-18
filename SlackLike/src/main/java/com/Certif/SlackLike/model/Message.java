package com.Certif.SlackLike.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;


@Entity
@Table(name="messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false, length = 255)
    private String message;

    @Column(name = "date_message")
    private LocalDateTime dateMessage;

    @ManyToOne
    @JoinColumn(name="user_id_fk")
    private User user;

    @ManyToOne
    @JoinColumn(name="channel_id_fk")
    private Channel channel;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, columnDefinition = "int4")
    //private Integer status;
    private MessageStatus status;

    public Message() {
    }

    public Message(String message, LocalDateTime dateMessage, User user, Channel channel, MessageStatus status) {
        this.message = message;
        this.dateMessage = dateMessage;
        this.user = user;
        this.channel = channel;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(LocalDateTime dateMessage) {
        this.dateMessage = dateMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", dateMessage=" + dateMessage +
                ", user=" + user +
                ", channel=" + channel +
                ", status=" + status +
                '}';
    }
}