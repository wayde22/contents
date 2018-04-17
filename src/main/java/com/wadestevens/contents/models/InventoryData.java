package com.wadestevens.contents.models;

import java.util.ArrayList;

public class InventoryData {

    static ArrayList<Inventory> inventories = new ArrayList<>();

    // getAll
    public static ArrayList<Inventory> getAll() {
        return inventories;
    }

    // add
    public static void add(Inventory newInventory) {
        inventories.add(newInventory);
    }

    // remove
    public static void remove(int id) {
        Inventory inventoryToRemove = getById(id);
        inventories.remove(inventoryToRemove);
    }

    //getById
    public static Inventory getById(int id) {

        Inventory theInventory = null;

        for (Inventory candidateInventory : inventories) {
            if (candidateInventory.getInventoryId() == id) {
                theInventory = candidateInventory;
            }
        }

        return theInventory;
    }

}
