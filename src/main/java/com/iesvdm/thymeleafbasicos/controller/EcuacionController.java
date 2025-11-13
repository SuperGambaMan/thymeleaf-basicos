package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.EcuacionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class EcuacionController {

    @GetMapping("/ecuacion")
    public String ecuacion (Model model, @ModelAttribute EcuacionDTO ecuacionDTO){
        model.addAttribute("ecuacionDTO", ecuacionDTO);
        return "ecuacion";
    }

    @PostMapping("/ecuacion")
    public String calculadoraSubmit (Model model, @ModelAttribute EcuacionDTO ecuacionDTO){

        log.info(ecuacionDTO.toString());

        double res = -ecuacionDTO.getB();

        model.addAttribute("resultado","");
        return "ecuacion";
    }
}
