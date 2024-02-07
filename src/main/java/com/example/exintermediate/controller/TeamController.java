package com.example.exintermediate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.service.TeamService;

@Controller
@RequestMapping("/baseball")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping({"/index","/index/"})
    public String index(Model model) {
        model.addAttribute("teamList", teamService.showList());
        return "Ex01/team-list";
    }

    @GetMapping({"/showDetail","/showDetail/"})
    public String showDetail(Integer id, Model model) {
        model.addAttribute("team", teamService.showDetail(id));
        return "Ex01/team-detail";
    }
    
}
