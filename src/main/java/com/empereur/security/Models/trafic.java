package com.empereur.security.Models;

import javax.persistence.*;

@Entity
public class trafic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long traficID;
}
