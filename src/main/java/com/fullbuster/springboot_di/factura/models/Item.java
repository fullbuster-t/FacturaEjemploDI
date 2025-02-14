package com.fullbuster.springboot_di.factura.models;

public class Item {

    private Product product;
    private Integer quantify;



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantify() {
        return quantify;
    }

    public void setQuantify(Integer quantify) {
        this.quantify = quantify;
    }
}
