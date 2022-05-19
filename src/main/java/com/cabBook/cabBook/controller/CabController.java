package com.cabBook.cabBook.controller;

import com.cabBook.cabBook.model.Cab;
import com.cabBook.cabBook.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CabController {

    @Autowired
    public CabService cabService;

    @GetMapping("/cab")
    @ResponseBody
    public String getCab(@RequestParam Integer id) {
        cabService.getCabs(id);
        return "Id" + id;
    }

    @GetMapping("/cab/all")
    @ResponseBody
    public List<Map.Entry<Integer, Cab>> getAllCabs() {
        return cabService.getAllCabs();
    }
}
