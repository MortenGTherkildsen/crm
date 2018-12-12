package com.example.crm.model;

import javax.persistence.*;

@Entity(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "owner")
    private Contact owner;

    private String timestamp;
    private int status;

    public Note(String subject, String content, Contact owner, String timestamp, int status) {
        this.subject = subject;
        this.content = content;
        this.owner = owner;
        this.timestamp = timestamp;
        this.status = status;
    }

    public Note() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Contact getOwner() {
        return owner;
    }

    public void setOwner(Contact owner) {
        this.owner = owner;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", owner=" + owner +
                ", timestamp='" + timestamp + '\'' +
                ", status=" + status +
                '}';
    }
}
