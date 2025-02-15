package com.fullbuster.springboot_di.factura;

import com.fullbuster.springboot_di.factura.models.Item;
import com.fullbuster.springboot_di.factura.models.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "utf-8")
public class AppConfig {

    @Bean
    @Primary
    List<Item> itemsInvoice() {
        Product p1 = new Product("Audifonos Diadema Yeyian Flare", 800);
        Product p2 = new Product("Mouse Gamer Yeyian Slayer", 550);
        List<Item> items = Arrays.asList(new Item(p1, 3), new Item(p2, 4));
        return items;
    }

    @Bean
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Monitor Asus 24", 1800);
        Product p2 = new Product("Notebook Razer", 7500);
        Product p3 = new Product("Imresora Brother T720DW", 3500);
        Product p4 = new Product("Escritorio Office 270XR", 3500);
        List<Item> items = Arrays.asList(new Item(p1, 3), new Item(p2, 4), new Item(p3, 2), new Item(p4, 7));
        return items;
    }

}
