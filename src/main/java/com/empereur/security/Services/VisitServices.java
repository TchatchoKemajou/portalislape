package com.empereur.security.Services;

import com.empereur.security.DTO.VisiteDTO;
import com.empereur.security.Models.Historique;
import com.empereur.security.Models.Visite;
import com.empereur.security.Repository.VisitRepository;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VisitServices {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private  VisitorService visitorService;

    @Autowired
    private  GuardServices guardServices;

    @Autowired
    private  SiteSevices siteSevices;

    @Autowired
    private HistoryServices historyServices;

    public List<Visite> allVisits(){
        return  visitRepository.findAll();
    }

    public  Visite saveVisit(VisiteDTO visitedto){
        Visite visite = new Visite();
        BeanUtils.copyProperties(visitedto, visite);
        visite.setGuardID(guardServices.guardById(visitedto.getGuardID()));
        visite.setVisitorId(visitorService.visiteurById(visitedto.getVisitorId()));
        visite.setVisitSite(siteSevices.siteById(visitedto.getVisitSite()));
        visite.setVisitStatut("En cours");
        ///visite.setVisitCarteTemp("");
        visite.setVisitDate(new java.sql.Date(new Date().getTime()));
        visite.setVisitTimeStar(String.valueOf(new java.sql.Time(new Date().getTime())));
        return  visitRepository.save(visite);
    }

    public Visite saveAttente(VisiteDTO visitedto){
        Visite visite = new Visite();
        BeanUtils.copyProperties(visitedto, visite);
        visite.setGuardID(guardServices.guardById(visitedto.getGuardID()));
        visite.setVisitorId(visitorService.visiteurById(visitedto.getVisitorId()));
        visite.setVisitSite(siteSevices.siteById(visitedto.getVisitSite()));
        visite.setVisitStatut("Attendu");
        //visite.setVisitCarteTemp("");
        visite.setVisitDate(new java.sql.Date(new Date().getTime()));

        return  visitRepository.save(visite);
    }


    public Visite endVisite(Long id){
        Visite visite = visitRepository.getById(id);
        Historique historique = new Historique();

        visite.setVisiTimeEnd(String.valueOf(new java.sql.Time(new Date().getTime())));
        visite.setVisitStatut("Terminer");
        historique.setHisInfosId(id);
        historyServices.saveHistory(historique);

        return  visitRepository.save(visite);
    }

    public  Visite startVisite(Long id){
        Visite visite = visitRepository.getById(id);

        visite.setVisitTimeStar(String.valueOf(new java.sql.Time(new Date().getTime())));
        visite.setVisitStatut("En cours");

        return  visitRepository.save(visite);
    }

    public Visite findVisitByCarteTemp(String temporalcarte){
        List<Visite> visitList = visitRepository.findAll();

        for(Visite visite:visitList){
            if (visite.getVisitCarteTemp().equals(temporalcarte)){
                return  visite;
            }
        }
        return  null;
    }

    public List<Visite> allVisite(){return  visitRepository.findAll();}


    public  List<Visite> allVisitToDay(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Visite> visiteurList = visitRepository.findAll();
        List<Visite> visitesDay = new ArrayList<>();

        for (Visite visite:visiteurList){
            //System.out.printf(sdf.format(visite.getVisitDate()));
            //System.out.printf(String.valueOf(LocalDate.now()));
            if (sdf.format(visite.getVisitDate()).equals((LocalDate.now()).toString())){
                visitesDay.add(visite);
            }else return  null;
        }
        //System.out.printf(String.valueOf(visitesDay.size()));
        System.out.printf(String.valueOf(visitesDay));
        return  visitesDay;
    }

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("This is a title.", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("This is a paragraph.", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(paragraph2);
        document.close();
    }

    public static ByteArrayInputStream employeesReport() {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(80);
            table.setWidths(new int[] { 4, 4, 4 });

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Address", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Email", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

//            for (Employee employee : employees) {
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Phrase(employee.getEmp_name()));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(employee.getEmp_address()));
//                cell.setPaddingLeft(5);
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(employee.getEmp_email())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell.setPaddingRight(5);
//                table.addCell(cell);
//            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
