package com.fullbuster.springboot_di.factura.models;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Invoice {

    @Autowired
    private Client client;
    @Value("${invoice.description}")
    private String description;
    @Autowired
    @Qualifier("itemsInvoiceOffice")
    private List<Item> items;

    @PostConstruct
    public void init() {
        // Lógica de inicialización aquí
        System.out.println("Inicializando MiServicio...");
        System.out.println("Cargando configuraciones...");

        try {
            System.out.println("Estableciendo conexión a la base de datos...");
            //connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión a la base de datos establecida.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destruyendo el componete Invoice");
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
//        int total = 0;
//        for (Item item : items) {
//            total += item.getAmount();
//        }

        int total = items.stream()
                .map(item -> item.getAmount())
                .reduce(0, (sum, amount) -> sum + amount);
        return total;
    }
}
