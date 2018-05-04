package com.eginwong.physical.fitnesstracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class FitnessLog {
    @Id
    @Column(columnDefinition = "DATE")
    private LocalDate logDate;
    private int pushups;
    private int pullups;
    private int crunches;
    private int supermans;

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public int getPushups() {
        return pushups;
    }

    public void setPushups(int pushups) {
        this.pushups = pushups;
    }

    public int getPullups() {
        return pullups;
    }

    public void setPullups(int pullups) {
        this.pullups = pullups;
    }

    public int getCrunches() {
        return crunches;
    }

    public void setCrunches(int crunches) {
        this.crunches = crunches;
    }

    public int getSupermans() {
        return supermans;
    }

    public void setSupermans(int supermans) {
        this.supermans = supermans;
    }

    @Override
    public String toString() {
        return "FitnessLog{" +
                "logDate=" + logDate +
                ", pushups=" + pushups +
                ", pullups=" + pullups +
                ", crunches=" + crunches +
                ", supermans=" + supermans +
                '}';
    }
}
