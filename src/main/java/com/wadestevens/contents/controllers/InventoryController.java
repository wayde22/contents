package com.wadestevens.contents.controllers;

import com.wadestevens.contents.models.Inventory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;

//import com.wadestevens.contents.models.data.InventoryDao;

@Controller
@RequestMapping("inventory")
public class InventoryController {

//    @Autowired
//    private InventoryDao inventoryDao;

    static ArrayList<Inventory> inventories = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model) {

//        model.addAttribute("inventories", inventoryDao.findAll());
        model.addAttribute("inventories", inventories);
        model.addAttribute("title", "Inventory List");

        return "inventory/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddInventoryForm(Model model){

        model.addAttribute("title", "Add Inventory");

        return "inventory/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String inventoryRoom, @RequestParam String inventoryItem,
                                       @RequestParam String inventoryDescription, @RequestParam String inventoryModel,
                                       @RequestParam Date inventoryPurchaseDate, @RequestParam double inventoryPurchaseValue,
                                       @RequestParam double inventoryCurrentValue) {

        Inventory newInventory = new Inventory(inventoryRoom, inventoryItem, inventoryDescription, inventoryModel,
                inventoryPurchaseDate, inventoryPurchaseValue, inventoryCurrentValue);
        inventories.add(newInventory);

        return "redirect:";
    }

    @RequestMapping(value= "remove", method = RequestMethod.GET)
    public String displayRemoveInventoryForm(Model model) {
        model.addAttribute("inventory", inventories);
        model.addAttribute("title", "Remove Item");
        return "inventory/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveInventoryForm(@RequestParam ArrayList<Integer> inventory) {

        for (int aInventory : inventory) {
            inventory.remove(aInventory);
        }

        return "redirect:";
    }

}

