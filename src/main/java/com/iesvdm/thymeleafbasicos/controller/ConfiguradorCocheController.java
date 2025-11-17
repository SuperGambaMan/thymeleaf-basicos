package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.ConfiguradorDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller

@RequestMapping("/configurador")
public class ConfiguradorCocheController {

    //ruta /configurador -> vacio coge la del @RequestMapping
    @GetMapping("")
    public String recibirConfiguradorDTO (Model model, @ModelAttribute ConfiguradorDTO configuradorDTO){


        model.addAttribute("configuradorDTO", configuradorDTO);
        return "configurador";
    }

    //ruta
    @PostMapping("/configurador/enviar")
    public String calendarioMes(Model model, @Valid @ModelAttribute ConfiguradorDTO configuradorDTO){

        log.info(configuradorDTO.toString());

        /// ///

        model.addAttribute("msg", "");

        return "show-month";
    }
}
