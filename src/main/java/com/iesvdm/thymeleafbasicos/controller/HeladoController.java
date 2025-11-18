package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.HeladoDTO;
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

@RequestMapping("/helado")
public class HeladoController {

    //ruta /helado -> vacio coge la del @RequestMapping
    @GetMapping("")
    public String recibirHeladoDTO (Model model, @ModelAttribute HeladoDTO heladoDTO){

        //

        model.addAttribute("heladoDTO", heladoDTO);

        return "helado";
    }

    //ruta /helado/enviar
    @PostMapping("/enviar")
    public String porcentajeHelado(Model model, @Valid @ModelAttribute HeladoDTO heladoDTO){

        log.info(heladoDTO.toString());

       int chocolate= heladoDTO.getChocolate();
       int fresa= heladoDTO.getFresa();
       int vainilla= heladoDTO.getVainilla();
       boolean check;

        if (vainilla + fresa + chocolate > 100) {
            model.addAttribute("msg",
                    "La suma de los porcentajes debe ser menor o igual que 100." +
                            " Por favor, introduzca de nuevo los porcentajes");
        } else {
            check = true;
            model.addAttribute("check",check);
            model.addAttribute("chocolate", heladoDTO.getChocolate());
            model.addAttribute("fresa", heladoDTO.getFresa());
            model.addAttribute("vainilla", heladoDTO.getVainilla());
        }

        return "helado";
    }
}
