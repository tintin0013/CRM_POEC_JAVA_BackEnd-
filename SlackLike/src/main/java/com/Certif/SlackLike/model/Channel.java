package com.Certif.SlackLike.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="channels")
public class Channel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false,length = 50)
    private String  name;

    @Column(name="creation_date",nullable = false)
    private LocalDateTime creationDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, columnDefinition = "int4")
   // private Integer status;
    private ChannelStatus status;

    @OneToMany(mappedBy ="channel" ,cascade = CascadeType.ALL)
    private List<Message> messages;

    public Channel() {
    }

    public Channel(String name, LocalDateTime creationDate, ChannelStatus status) {
        this.name = name;
        this.creationDate = creationDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public ChannelStatus getStatus() {
        return status;
    }

    public void setStatus(ChannelStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", status=" + status +
                '}';
    }

}
