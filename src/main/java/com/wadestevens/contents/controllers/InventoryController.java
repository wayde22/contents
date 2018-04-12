package com.wadestevens.contents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("inventory")
public class InventoryController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Kontent");

        return "inventory/index";
    }

}
