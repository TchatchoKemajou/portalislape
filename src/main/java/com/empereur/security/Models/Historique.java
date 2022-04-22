package com.empereur.security.Models;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Historique {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long histId;

    private Date histDate;

//    private String hisTimeIn;
//
//    private String hisTimeOut;

    private  Long hisInfosId;

    public Historique() {
    }

    public Historique(Long histId, Date histDate, Long hisInfosId) {
        this.histId = histId;
        this.histDate = histDate;
//        this.hisTimeIn = hisTimeIn;
//        this.hisTimeOut = hisTimeOut;
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


//    public String getHisTimeIn() {
//        return hisTimeIn;
//    }
//
//    public void setHisTimeIn(String hisTimeIn) {
//        this.hisTimeIn = hisTimeIn;
//    }
//
//    public String getHisTimeOut() {
//        return hisTimeOut;
//    }
//
//    public void setHisTimeOut(String hisTimeOut) {
//        this.hisTimeOut = hisTimeOut;
//    }

    public Long getHisInfosId() {
        return hisInfosId;
    }

    public void setHisInfosId(Long hisInfosId) {
        this.hisInfosId = hisInfosId;
    }
}
