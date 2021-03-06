package com.eginwong.physical.fitnesstracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * The main fitness log record.
 */
@Entity
public class FitnessLog {
    @Id
    private int id;

    // beware of using LocalDate as the id. Will cause tons of headache
    @Column(columnDefinition = "DATE")
    private LocalDate logDate;
    private int pushups;
    private int pullups;
    private int crunches;
    private int supermans;
    // to handle nullable values
    private Double weight;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets log date.
     *
     * @return the log date
     */
    public LocalDate getLogDate() {
        return logDate;
    }

    /**
     * Sets log date.
     *
     * @param logDate the log date
     */
    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    /**
     * Gets pushups.
     *
     * @return the pushups
     */
    public int getPushups() {
        return pushups;
    }

    /**
     * Sets pushups.
     *
     * @param pushups the pushups
     */
    public void setPushups(int pushups) {
        this.pushups = pushups;
    }

    /**
     * Gets pullups.
     *
     * @return the pullups
     */
    public int getPullups() {
        return pullups;
    }

    /**
     * Sets pullups.
     *
     * @param pullups the pullups
     */
    public void setPullups(int pullups) {
        this.pullups = pullups;
    }

    /**
     * Gets crunches.
     *
     * @return the crunches
     */
    public int getCrunches() {
        return crunches;
    }

    /**
     * Sets crunches.
     *
     * @param crunches the crunches
     */
    public void setCrunches(int crunches) {
        this.crunches = crunches;
    }

    /**
     * Gets supermans.
     *
     * @return the supermans
     */
    public int getSupermans() {
        return supermans;
    }

    /**
     * Sets supermans.
     *
     * @param supermans the supermans
     */
    public void setSupermans(int supermans) {
        this.supermans = supermans;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        FitnessLog that = (FitnessLog) o;

        return new org.apache.commons.lang.builder.EqualsBuilder()
                .append(pushups, that.pushups)
                .append(pullups, that.pullups)
                .append(crunches, that.crunches)
                .append(supermans, that.supermans)
                .append(weight, that.weight)
                .append(logDate, that.logDate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang.builder.HashCodeBuilder(17, 37)
                .append(logDate)
                .append(pushups)
                .append(pullups)
                .append(crunches)
                .append(supermans)
                .append(weight)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "FitnessLog{" +
                "id=" + id +
                ", logDate=" + logDate +
                ", pushups=" + pushups +
                ", pullups=" + pullups +
                ", crunches=" + crunches +
                ", supermans=" + supermans +
                ", weight=" + weight +
                '}';
    }
}
