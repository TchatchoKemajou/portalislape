package com.empereur.security.RestController;

import com.empereur.security.DTO.VisiteDTO;
import com.empereur.security.Models.Visite;
import com.empereur.security.Services.VisitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/visite")
public class VisiteRestController {

    @Autowired
    private VisitServices visitServices;

    @GetMapping("/allvisite")
    public List<Visite> allVisites(){return  visitServices.allVisits();}

    @GetMapping("/allvisiteday")
    public List<Visite> allCustomVisites(){return  visitServices.allVisitToDay();}

    @PostMapping("/addattente")
    public Visite addAttente(@RequestBody VisiteDTO visite){
        return visitServices.saveAttente(visite);
    }

    @PutMapping("/endvisite/{id}")
    public Visite SetEndOfVisite(@PathVariable Long id){
        return visitServices.endVisite(id);
    }

    @PutMapping("/startvisite/{id}")
    public Visite SetStartOfVisite(@PathVariable Long id){
        return visitServices.startVisite(id);
    }

    @PostMapping("/addvisite")
    public Visite addVisite(@RequestBody VisiteDTO visiteDTO){
        return visitServices.saveVisit(visiteDTO);
    }

    @GetMapping("/generatepdf")
    public void generatePDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        visitServices.export(response);
    }

    @GetMapping(value = "/downloadpdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {

        //List<Employee> allEmployees = employeeRepository.findAll();

        ByteArrayInputStream bis = visitServices.employeesReport();

        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", "attachment;filename=employees.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
