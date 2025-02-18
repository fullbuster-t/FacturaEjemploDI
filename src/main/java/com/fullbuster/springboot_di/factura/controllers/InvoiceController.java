package com.fullbuster.springboot_di.factura.controllers;

import com.fullbuster.springboot_di.factura.models.Client;
import com.fullbuster.springboot_di.factura.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/invoices")
@RestController
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/detail")
    public Invoice detailInvoice() {

        Invoice i = new Invoice();

        Client c = new Client();
        c.setName(invoice.getClient().getName());
        c.setLastname(invoice.getClient().getLastname());

        i.setClient(c);
        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());

        return i;
    }
}
