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

import java.util.Random;
import java.util.stream.IntStream;


@Slf4j
@Controller

@RequestMapping("/ajedrez")
public class AjedrezController {

    //ruta /ajedrez -> vacio coge la del @RequestMapping
    @GetMapping("")
    public String recibirAjedrezDTO (Model model, @ModelAttribute AjedrezDTO ajedrezDTO){

        int[] rows = IntStream.rangeClosed(1,8).toArray();
        int[] cols = IntStream.rangeClosed(1,8).toArray();

        model.addAttribute("rows", rows);
        model.addAttribute("cols", cols);
        model.addAttribute("ajedrezDTO", ajedrezDTO);

        return "ajedrez";
    }

    //ruta /ajedrez/tablero
    @PostMapping("/tablero")
    public String tableroConFichas(Model model, @Valid @ModelAttribute AjedrezDTO ajedrezDTO){

        log.info(ajedrezDTO.toString());

        Random random = new Random();

        int caballoFila, caballoCol;
        int alfilFila, alfilCol;

        // Posiciones aleatorias
        caballoFila = random.nextInt(8) + 1;
        caballoCol  = random.nextInt(8) + 1;

        do {
            alfilFila = random.nextInt(8) + 1;
            alfilCol  = random.nextInt(8) + 1;
        } while (caballoFila == alfilFila && caballoCol == alfilCol);

        model.addAttribute("caballoFila", caballoFila);
        model.addAttribute("caballoCol", caballoCol);
        model.addAttribute("alfilFila", alfilFila);
        model.addAttribute("alfilCol", alfilCol);

        int[] rows = IntStream.rangeClosed(1, 8).toArray();
        int[] cols = IntStream.rangeClosed(1, 8).toArray();

        model.addAttribute("rows", rows);
        model.addAttribute("cols", cols);

        return "ajedrez";
    }
}
