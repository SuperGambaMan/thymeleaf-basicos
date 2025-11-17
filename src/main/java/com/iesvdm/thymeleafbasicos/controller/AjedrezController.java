package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.AjedrezDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.IntStream;


@Slf4j
@Controller

@RequestMapping("/ajedrez")
public class AjedrezController {

    //ruta /ajedrez -> vacio coge la del @RequestMapping
    @GetMapping("")
    public String recibirConfiguradorDTO (Model model, @ModelAttribute AjedrezDTO ajedrezDTO){

        int[] rows = IntStream.rangeClosed(1,8).toArray();
        int[] cols = IntStream.rangeClosed(1,8).toArray();

        model.addAttribute("rows", rows);
        model.addAttribute("cols", cols);
        model.addAttribute("ajedrezDTO", ajedrezDTO);

        return "ajedrez";
    }

    //ruta
    @PostMapping("/ajedrez/enviar")
    public String calendarioMes(Model model, @Valid @ModelAttribute AjedrezDTO ajedrezDTO){

        log.info(ajedrezDTO.toString());

        /// ///

        model.addAttribute("msg", "");

        return "show-month";
    }
}
