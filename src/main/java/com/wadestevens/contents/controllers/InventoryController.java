package com.wadestevens.contents.controllers;

//import com.wadestevens.contents.models.Inventory;
//import com.wadestevens.contents.models.data.InventoryDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("inventory")
public class InventoryController {

//    @Autowired
//    private InventoryDao inventoryDao;

    @RequestMapping(value = "")
    public String index(Model model) {

//        model.addAttribute("inventories", inventoryDao.findAll());
        model.addAttribute("title", "Inventory List");

        return "inventory/index";
    }
}

