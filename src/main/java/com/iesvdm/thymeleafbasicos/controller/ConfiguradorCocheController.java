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

@RequestMapping("/configuradorCoche")
public class ConfiguradorCocheController {

    //ruta /configurador -> vacio coge la del @RequestMapping
    @GetMapping("")
    public String recibirConfiguradorDTO (Model model, @ModelAttribute ConfiguradorDTO configuradorDTO){


        model.addAttribute("configuradorDTO",  configuradorDTO);
        return "configuradorCoche";
    }

    //ruta /configurador/enviar
    @PostMapping("/enviar")
    public String enviarConfiguracion(Model model, @ModelAttribute ConfiguradorDTO configuradorDTO){

        log.info(configuradorDTO.toString());

        // obtenemos el color y la moldura del html
        String color = configuradorDTO.getColorTapiceria();
        String moldura = configuradorDTO.getMoldura();

        //escrbimos la ruta de la imagen para enviarsela al html y colocarla en el src
        String imagen = "/img/interior_" + color + "_" + moldura + ".png";

        model.addAttribute("imagenCoche", imagen);
        model.addAttribute("colorTapiceria", color);
        model.addAttribute("molduraTapiceria", moldura);
        model.addAttribute("configuradorDTO", configuradorDTO);

        return "configuradorCoche";
    }
}
