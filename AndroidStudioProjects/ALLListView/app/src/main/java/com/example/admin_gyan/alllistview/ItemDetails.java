package com.example.admin_gyan.alllistview;

/**
 * Created by Admin_GYAN on 1/5/2017.
 */
public class ItemDetails {

    private String name;
    private String itemDescription;
    private String price;
    private int imageNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getPrice() {
        return price;
    }

    public int getImageNumber() {
        return imageNumber;
    }
}
