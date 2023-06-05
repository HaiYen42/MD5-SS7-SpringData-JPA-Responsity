package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rikkei.academy.model.Province;
import rikkei.academy.service.province.IProvinceService;

@Controller
@RequestMapping(value = {"/province"})
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;
    @GetMapping
    public String showListProvince(Model model){
        Iterable<Province> provinces = provinceService.findALl();
        model.addAttribute("listProvince", provinces);
        return "province/list";
    }
}
