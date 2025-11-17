package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.CalendarRequestDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Slf4j
@Controller

@RequestMapping("/calendar")
public class CalendarController {

    //ruta /cuadratica -> vacio coge la del @RequestMapping
    @GetMapping("")
    public String getCalendarForm (Model model, @ModelAttribute CalendarRequestDTO calendarRequestDTO, Locale locale){

        //Fecha Actual
        //Calendar.getInstance().getDisplayName(Calendar.MONTH,Calendar.LONG_FORMAT,new Locale("Es"));

        List<String> meses =new ArrayList<>(12);

        Calendar calendar = Calendar.getInstance();
        // Este calendario esta a fecha de hoy
        for (int i = 0; i < 12; i++) {
            //El calendario lo desplaza a cada mes
            calendar.set(2025,i,1);
            //Añades a meses,el nombre del mes en español
            meses.add(calendar.getDisplayName(Calendar.MONTH,Calendar.LONG_FORMAT,locale));
        }

        model.addAttribute("meses", meses);
        model.addAttribute("calendarRequestDTO", calendarRequestDTO);
        return "calendar";
    }

    //ruta
    @PostMapping("/calendar/enviar")
    public String calendarioMes(Model model, @Valid @ModelAttribute CalendarRequestDTO calendarRequestDTO){

        log.info(calendarRequestDTO.toString());

        String mes = calendarRequestDTO.getMes();
        int anio = calendarRequestDTO.getAnio();

        model.addAttribute("msg", "");

        return "show-month";
    }
}
