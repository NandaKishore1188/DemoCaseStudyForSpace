package com.capg.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AdminData")
public class AdminData {

    @Id
    private int id;
    private String adminName;
    private String admin_password;
}
