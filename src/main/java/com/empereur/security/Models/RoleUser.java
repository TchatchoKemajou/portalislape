package com.empereur.security.Models;

import javax.persistence.*;

@Entity
public class RoleUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long roleId;

    private String roleName;
}
