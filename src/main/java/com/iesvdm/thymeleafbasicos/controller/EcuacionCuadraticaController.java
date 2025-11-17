package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.CuadraticaDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.math.MathContext;

@Slf4j
@Controller

@RequestMapping("/cuadratica")
public class EcuacionCuadraticaController {

    //ruta /cuadratica/formulario
    @GetMapping("/formulario")
    public String ecuacion (Model model, @ModelAttribute CuadraticaDTO cuadraticaDTO){
        model.addAttribute("cuadraticaDTO", cuadraticaDTO);
        return "cuadratica";
    }

    //ruta /cuadratica/formulario/enviar
    @PostMapping("/formulario/enviar")
    public String formularioEnviar(Model model, @Valid @ModelAttribute CuadraticaDTO cuadraticaDTO){

        log.info(cuadraticaDTO.toString());

        BigDecimal a = cuadraticaDTO.getA();
        BigDecimal b = cuadraticaDTO.getB();
        BigDecimal c = cuadraticaDTO.getC();
        //Al ser BigDecimal se tiene que calcular con metodos --> subtract = -

        BigDecimal discriminante = b.pow(2).subtract(BigDecimal.valueOf(4).multiply(a).multiply(c));

        if (discriminante.compareTo(BigDecimal.ZERO)>=0) {

            BigDecimal raizDiscriminante = discriminante.sqrt(MathContext.DECIMAL128);

            BigDecimal raiz1 = b.negate().add(raizDiscriminante).divide(BigDecimal.valueOf(2).multiply(a), MathContext.DECIMAL128);
            BigDecimal raiz2 = b.negate().subtract(raizDiscriminante).divide(BigDecimal.valueOf(2).multiply(a), MathContext.DECIMAL128);

            //cuadraticaDTO.setRaiz1(raiz1);
            //cuadraticaDTO.setRaiz2(raiz2);


            model.addAttribute("msg", "Ec .con soluciones");

            model.addAttribute("raiz1", raiz1);
            model.addAttribute("raiz2", raiz2);

        } else {

            model.addAttribute("msg", "Ec. sin solución");

        }

        return "cuadratica";
    }
}
