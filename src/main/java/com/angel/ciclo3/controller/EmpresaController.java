package com.angel.ciclo3.controller;

import com.angel.ciclo3.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    //-----------------------------------
    @GetMapping("/verempresas")
    public String viewEmpresas(Model model){
        model.addAttribute("empresaList", empresaService.getAllEmpresas());
        return "verempresas";
    }

}
