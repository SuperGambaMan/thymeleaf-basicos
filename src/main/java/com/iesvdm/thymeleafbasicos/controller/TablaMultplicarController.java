package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.TablaMultiplicarDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class TablaMultplicarController {

    @GetMapping("/tablamultiplicar")
    public String tablaMultiplicar (Model model, @ModelAttribute TablaMultiplicarDTO tablaMultiplicarDTO){
        model.addAttribute("tablaMultiplicarDTO", tablaMultiplicarDTO);
        return "tablamultiplicar";
    }

    @PostMapping("/tablamultiplicar")
    public String calculadoraSubmit (Model model, @ModelAttribute TablaMultiplicarDTO tablaMultiplicarDTO){

        log.info(tablaMultiplicarDTO.toString());

        List<String> resultados = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            resultados.add(tablaMultiplicarDTO.getNumero() + " x " + i + " = " + (tablaMultiplicarDTO.getNumero() * i));
        }
//
//        String res = "<table border="+1+">" +
//                "<tr>" +
//                "<td>" +tablaMultiplicarDTO.getNumero()+"</td>" +
//                "<td>" +(0)+"</td>" +
//                "<td>" +(tablaMultiplicarDTO.getNumero())+"</td>" +
//                "<td>" +(tablaMultiplicarDTO.getNumero()*2)+"</td>" +
//                "<td>" +(tablaMultiplicarDTO.getNumero()*3)+"</td>" +
//                "<td>" +(tablaMultiplicarDTO.getNumero()*4)+"</td>" +
//                "<td>" +(tablaMultiplicarDTO.getNumero()*5)+"</td>" +
//                "<td>" +(tablaMultiplicarDTO.getNumero()*6)+"</td>" +
//                "<td>" +(tablaMultiplicarDTO.getNumero()*7)+"</td>" +
//                "<td>" +(tablaMultiplicarDTO.getNumero()*8)+"</td>" +
//                "<td>" +(tablaMultiplicarDTO.getNumero()*9)+"</td>" +
//                "<tr/>"+
//                "</table>";
//
//        String res2="<table border="+1+">";
//        for (int i = 1; i <= 10; i++) {
//            res += "<td> Tabla del"+tablaMultiplicarDTO.getNumero();
//        }

        model.addAttribute("resultados",resultados);
        model.addAttribute("numero", tablaMultiplicarDTO.getNumero());

        return "tablamultiplicar";
    }
}
