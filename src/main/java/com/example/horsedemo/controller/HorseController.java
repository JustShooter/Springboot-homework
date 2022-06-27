package com.example.horsedemo.controller;

import com.example.horsedemo.repository.Horse;
import com.example.horsedemo.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HorseController {

    @Autowired
    private HorseService horseService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Horse> listHorses = horseService.listAll();
        model.addAttribute("listHorses", listHorses);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Horse horse = new Horse();
        model.addAttribute("horse", horse);

        return "new_horse";
    }

    @PostMapping("/save")
    public String saveHorse(Horse horse) {
        horseService.save(horse);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String showEditHorsePage(@PathVariable(name = "id") Integer id, Model model) {
        Horse horse = horseService.get(id);
        model.addAttribute("horse", horse);


        return "edit_horse";
    }

    @RequestMapping("/delete/{id}")
    public String deleteHorse(@PathVariable(name = "id") int id) {
        horseService.delete(id);
        return "redirect:/";
    }


}
