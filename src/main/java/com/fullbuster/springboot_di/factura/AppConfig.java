package com.fullbuster.springboot_di.factura;

import com.fullbuster.springboot_di.factura.models.Item;
import com.fullbuster.springboot_di.factura.models.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "utf-8")
public class AppConfig {

    @Bean
    List<Item> intemsInvoice() {
        Product p1 = new Product("Audifonos Diadema Yeyian Flare", 800);
        Product p2 = new Product("Mouse Gamer Yeyian Slayer", 550);
        List<Item> items = Arrays.asList(new Item(p1, 3), new Item(p2, 4));
        return items;
    }

}
