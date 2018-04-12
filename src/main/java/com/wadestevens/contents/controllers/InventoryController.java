package com.wadestevens.contents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("inventory")
public class InventoryController {

    @RequestMapping(value = "")
    public String index() {
        return "inventory/index";
    }

}
