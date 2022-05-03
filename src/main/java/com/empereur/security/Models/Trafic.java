package com.empereur.security.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Trafic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long traficID;

    private Long personId;

    private Date traficDay;

    private String traficTime;

    private String traficType;

    public Trafic() {
    }

    public Trafic(Long traficID, Long personId, Date traficDay, String traficTime, String traficType) {
        this.traficID = traficID;
        this.personId = personId;
        this.traficDay = traficDay;
        this.traficTime = traficTime;
        this.traficType = traficType;
    }

    public Long getTraficID() {
        return traficID;
    }

    public void setTraficID(Long traficID) {
        this.traficID = traficID;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Date getTraficDay() {
        return traficDay;
    }

    public void setTraficDay(Date traficDay) {
        this.traficDay = traficDay;
    }

    public String getTraficTime() {
        return traficTime;
    }

    public void setTraficTime(String traficTime) {
        this.traficTime = traficTime;
    }

    public String getTraficType() {
        return traficType;
    }

    public void setTraficType(String traficType) {
        this.traficType = traficType;
    }
}
