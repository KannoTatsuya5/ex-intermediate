package com.example.exintermediate.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.form.FashionForm;
import com.example.exintermediate.model.Fashion;
import com.example.exintermediate.service.FashionService;

@Controller
@RequestMapping("/fashion")
public class FashionController {
    @Autowired
    private FashionService fashionService;

    /**
     * 衣類検索画面にフォーワード.
     * @param model
     * @return 衣類検索画面
     */
    @GetMapping({"/", ""})
    public String index(Model model) {
        Map<Integer, String> genderMap = new LinkedHashMap<>();
		genderMap.put(0, "Man");
		genderMap.put(1, "Woman");
		model.addAttribute("genderMap", genderMap);

		Map<Integer, String> colorMap = new LinkedHashMap<>();
		colorMap.put(1, "赤");
		colorMap.put(2, "青");
		colorMap.put(3, "白");
		colorMap.put(4, "黄");
		model.addAttribute("colorMap", colorMap);
        return "Ex03/search-fashion";
    }

    /**
     * 衣類検索結果を表示.
     * @param form(color,gender)
     * @param model
     * @return 衣類検索画面
     */
    @PostMapping({"/search", "/search/"})
    public String search(FashionForm form, Model model) {
        Map<Integer, String> genderMap = new LinkedHashMap<>();
		genderMap.put(0, "Man");
		genderMap.put(1, "Woman");
		model.addAttribute("genderMap", genderMap);

		Map<Integer, String> colorMap = new LinkedHashMap<>();
		colorMap.put(1, "赤");
		colorMap.put(2, "青");
		colorMap.put(3, "白");
		colorMap.put(4, "黄");
		model.addAttribute("colorMap", colorMap);
        List<Fashion> fashionList = fashionService.showFashionList(form.getColor(), form.getGender());
        model.addAttribute("fashionList", fashionList);
        return "Ex03/search-fashion";
    }
}
