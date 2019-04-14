package com.virtualelection.cloudproject1.Model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="elections")
@EntityListeners(AuditingEntityListener.class)

public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Title",nullable = false)
    private String title;

    @Column(name = "Starttime",nullable = false)
    @CreatedDate
    private Date startTime;

    @Column(name = "EndTime",nullable = false)
    @CreatedDate
    private  Date endTime;

    @Column(name = "ListOfChoice",nullable = false)
    private String listOfChoice;

    @Column(name = "NumberOfVotes",nullable = false)
    private int numberOfVotes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getListOfChoice() {
        return listOfChoice;
    }

    public void setListOfChoice(String listOfChoice) {
        this.listOfChoice = listOfChoice;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }
}
