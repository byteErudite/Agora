package com.vaibhav.Agora.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


public class BookInventory {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private UUID bookInventoryId;

    private Boolean isAvailable;
    private Boolean isReserved;
    private UUID itemId;
    private Book book;
}
