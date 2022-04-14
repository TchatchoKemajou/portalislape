package com.empereur.security.Models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Entity
public class Historique {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long histId;

    private Date histDate;

    private Time hisTimeIn;

    private Time hisTimeOut;

    private  Long hisInfosId;

    public Historique() {
    }

    public Historique(Long histId, Date histDate, Time hisTimeIn, Time hisTimeOut, Long hisInfosId) {
        this.histId = histId;
        this.histDate = histDate;
        this.hisTimeIn = hisTimeIn;
        this.hisTimeOut = hisTimeOut;
        this.hisInfosId = hisInfosId;
    }

    public Long getHistId() {
        return histId;
    }

    public void setHistId(Long histId) {
        this.histId = histId;
    }

    public Date getHistDate() {
        return histDate;
    }

    public void setHistDate(Date histDate) {
        this.histDate = histDate;
    }


    public Time getHisTimeIn() {
        return hisTimeIn;
    }

    public void setHisTimeIn(Time hisTimeIn) {
        this.hisTimeIn = hisTimeIn;
    }

    public Time getHisTimeOut() {
        return hisTimeOut;
    }

    public void setHisTimeOut(Time hisTimeOut) {
        this.hisTimeOut = hisTimeOut;
    }

    public Long getHisInfosId() {
        return hisInfosId;
    }

    public void setHisInfosId(Long hisInfosId) {
        this.hisInfosId = hisInfosId;
    }
}
