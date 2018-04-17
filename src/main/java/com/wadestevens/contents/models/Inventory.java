package com.wadestevens.contents.models;

import java.util.Date;

public class Inventory {

    private String room;
    private String item;
    private String description;
    private String model;
    private Date purchaseDate;
    private double purchaseValue;
    private double currentValue;
    private int inventoryId;
    private static int nextId = 1;

    public Inventory(String room, String item, String description, String model, Date purchaseDate, double purchaseValue, double currentValue) {
        this();
        this.room = room;
        this.item = item;
        this.description = description;
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.purchaseValue = purchaseValue;
        this.currentValue = currentValue;
    }

    public Inventory(){
        inventoryId = nextId;
        nextId++;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Inventory.nextId = nextId;
    }
}
