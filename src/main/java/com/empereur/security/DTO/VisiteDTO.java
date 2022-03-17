package com.empereur.security.DTO;


import java.util.Date;

public class VisiteDTO {

    private  Long visitId;

    private Long visitorId;

    private Long guardID;

    private Long visitSite;

    private Date visitDate;

    private  String visitTimeStar;

    private  String visiTimeEnd;

    private  String visitStatut;

    private  String visitDescription;

    public VisiteDTO() {
    }

    public VisiteDTO(Long visitId, Long visitorId, Long guardID, Long visitSite, Date visitDate, String visitTimeStar, String visiTimeEnd, String visitStatut, String visitDescription) {
        this.visitId = visitId;
        this.visitorId = visitorId;
        this.guardID = guardID;
        this.visitSite = visitSite;
        this.visitDate = visitDate;
        this.visitTimeStar = visitTimeStar;
        this.visiTimeEnd = visiTimeEnd;
        this.visitStatut = visitStatut;
        this.visitDescription = visitDescription;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getGuardID() {
        return guardID;
    }

    public void setGuardID(Long guardID) {
        this.guardID = guardID;
    }

    public Long getVisitSite() {
        return visitSite;
    }

    public void setVisitSite(Long visitSite) {
        this.visitSite = visitSite;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitTimeStar() {
        return visitTimeStar;
    }

    public void setVisitTimeStar(String visitTimeStar) {
        this.visitTimeStar = visitTimeStar;
    }

    public String getVisiTimeEnd() {
        return visiTimeEnd;
    }

    public void setVisiTimeEnd(String visiTimeEnd) {
        this.visiTimeEnd = visiTimeEnd;
    }

    public String getVisitStatut() {
        return visitStatut;
    }

    public void setVisitStatut(String visitStatut) {
        this.visitStatut = visitStatut;
    }

    public String getVisitDescription() {
        return visitDescription;
    }

    public void setVisitDescription(String visitDescription) {
        this.visitDescription = visitDescription;
    }
}
