package com.eginwong.physical.fitnesstracker.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class FitnessLog {
   @Id
   private Date logDate;
   private int pushups;
   private int pullups;
   private int crunches;
   private int supermans;

   public Date getLogDate() {
       return logDate;
   }

   public void setLogDate(Date logDate) {
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
}
