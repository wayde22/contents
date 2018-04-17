package com.wadestevens.contents.controllers;

import com.wadestevens.contents.models.Inventory;
import com.wadestevens.contents.models.InventoryData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import com.wadestevens.contents.models.data.InventoryDao;

@Controller
@RequestMapping("inventory")
public class InventoryController {

//    @Autowired
//    private InventoryDao inventoryDao;

    @RequestMapping(value = "")
    public String index(Model model) {

//        model.addAttribute("inventories", inventoryDao.findAll());
        model.addAttribute("inventories", InventoryData.getAll());
        model.addAttribute("title", "Inventory List");

        return "inventory/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddInventoryForm(Model model){

        model.addAttribute("title", "Add Inventory");

        return "inventory/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute Inventory newInventory) {

        InventoryData.add(newInventory);

        return "redirect:";
    }

    @RequestMapping(value= "remove", method = RequestMethod.GET)
    public String displayRemoveInventoryForm(Model model) {
        model.addAttribute("inventory", InventoryData.getAll());
        model.addAttribute("title", "Remove Item");
        return "inventory/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveInventoryForm(@RequestParam int[] inventoryIds) {

        for (int inventoryId : inventoryIds) {
            InventoryData.remove(inventoryId);
        }

        return "redirect:";
    }

}

