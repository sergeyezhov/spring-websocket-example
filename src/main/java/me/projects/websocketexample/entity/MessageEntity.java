package me.projects.websocketexample.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "message")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_seq")
    @SequenceGenerator(name = "message_id_seq", sequenceName = "message_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "timestamp")
    private long timestamp;

    @PrePersist
    public void pre() {
        this.timestamp = Instant.now().getEpochSecond();
    }
}
