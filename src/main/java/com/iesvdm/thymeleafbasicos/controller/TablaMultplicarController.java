package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.TablaMultiplicarDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

        String res = "<table border="+1+">" +
                "<tr>" +
                "<td>" +tablaMultiplicarDTO.getNumero()+"</td>" +
                "<td>" +(0)+"</td>" +
                "<td>" +(tablaMultiplicarDTO.getNumero())+"</td>" +
                "<td>" +(tablaMultiplicarDTO.getNumero()*2)+"</td>" +
                "<td>" +(tablaMultiplicarDTO.getNumero()*3)+"</td>" +
                "<td>" +(tablaMultiplicarDTO.getNumero()*4)+"</td>" +
                "<td>" +(tablaMultiplicarDTO.getNumero()*5)+"</td>" +
                "<td>" +(tablaMultiplicarDTO.getNumero()*6)+"</td>" +
                "<td>" +(tablaMultiplicarDTO.getNumero()*7)+"</td>" +
                "<td>" +(tablaMultiplicarDTO.getNumero()*8)+"</td>" +
                "<td>" +(tablaMultiplicarDTO.getNumero()*9)+"</td>" +
                "<tr/>"+
                "</table>";

        model.addAttribute("resultado",res);

        return "tablamultiplicar";
    }
}
