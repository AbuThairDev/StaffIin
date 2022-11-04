package com.mamcet.staffiin.ui.slideshow.createProduct;


public class productList {
    String product_id;
    String product_name;
    String product_price ;
    String product_gst;
    public productList(String product_id, String product_name, String product_price, String product_gst) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_gst = product_gst;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public String getProduct_gst() {
        return product_gst;
    }
}
