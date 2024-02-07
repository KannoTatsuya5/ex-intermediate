package com.example.exintermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.exintermediate.service.HotelService;
import com.example.exintermediate.form.HotelFrom;
import com.example.exintermediate.model.Hotel;


@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping({"","/"})
    public String index(Model model) {
        return "Ex02/hotel";
    }

    @PostMapping({"/search","/search/"})
    public String search(HotelFrom form ,Model model) {
        List<Hotel> hotelList = hotelService.showLessPriceHotel(form.getPrice());
        model.addAttribute("hotelList", hotelList);
        return "Ex02/hotel";
    }
    
}
