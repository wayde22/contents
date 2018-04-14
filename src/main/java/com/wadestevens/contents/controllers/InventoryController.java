package com.wadestevens.contents.controllers;

//import com.wadestevens.contents.models.Inventory;
//import com.wadestevens.contents.models.data.InventoryDao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("inventory")
public class InventoryController {

//    @Autowired
//    private InventoryDao inventoryDao;

    static ArrayList<String> inventories = new ArrayList<>();

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
    public String processAddCheeseForm(@RequestParam String inventoryName) {

        inventories.add(inventoryName);

        return "redirect:";
    }

}

