package com.wadestevens.contents.controllers;

import com.wadestevens.contents.models.Inventory;
import com.wadestevens.contents.models.data.InventoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

//import com.wadestevens.contents.models.data.InventoryDao;

@Controller
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    private InventoryDao inventoryDao;

    @RequestMapping(value = "")
    public String index(Model model) {

//        model.addAttribute("inventories", InventoryDao.findAll());
        model.addAttribute("inventories", inventoryDao.findAll());
        model.addAttribute("title", "Inventory List");

        return "inventory/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddInventoryForm(Model model){

        model.addAttribute("title", "Add Inventory");
        model.addAttribute(new Inventory());

        return "inventory/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Inventory newInventory,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Inventory");

            return "inventory/add";
        }

        inventoryDao.save(newInventory);

        return "redirect:";
    }

    @RequestMapping(value= "remove", method = RequestMethod.GET)
    public String displayRemoveInventoryForm(Model model) {
        model.addAttribute("title", "Remove Item");
        model.addAttribute("inventories", inventoryDao.findAll());
        return "inventory/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveInventoryForm(@RequestParam int[] inventoryIds ) {

        for (int inventoryId : inventoryIds) {
            inventoryDao.delete(inventoryId);
        }

        return "redirect:";
    }

}

