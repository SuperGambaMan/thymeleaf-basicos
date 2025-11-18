package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.CalendarRequestDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    //ruta /calendar -> vacio coge la del @RequestMapping
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

    //ruta /calendar/mes
    @PostMapping("/mes")
    public String calendarioMes(Model model, @Valid @ModelAttribute CalendarRequestDTO calendarRequestDTO, Locale locale){

        log.info(calendarRequestDTO.toString());

        // obtenemos el mes y el año del formulario
        int mesNumero = Integer.parseInt(calendarRequestDTO.getMes()) - 1;  // Enero = 0
        int anio = calendarRequestDTO.getAnio();

        //creamos un calendario y le asignamos el primer dia del mes y el año que hemos recibido
        Calendar cal = Calendar.getInstance(locale);
        cal.set(anio, mesNumero, 1);

        // Los dias de la semana empiezan en domingo con .DAY_OF_WEEK
        int diaSemanaInicio = cal.get(Calendar.DAY_OF_WEEK);
        int diasMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Ajustar para que el lunes sea el primer día (ChatGPT)
        int offset = (diaSemanaInicio == Calendar.SUNDAY) ? 6 : diaSemanaInicio - 2;

        //creamos una lista de todas las semanas del mes lista de dias
        // dentro de listas de semanas (Una matriz)
        List<List<String>> semanas = new ArrayList<>();
        //y creamos otra lista para definir la semana actual
        List<String> semanaActual = new ArrayList<>();

        // Rellenar huecos antes del día 1 para que no se desordene la tabla
        for (int i = 0; i < offset; i++) {
            semanaActual.add("");
        }

        // despues rellenamos los días del mes
        for (int dia = 1; dia <= diasMes; dia++) {
            semanaActual.add(String.valueOf(dia));
            //cuando semana actual llega a 7 dias se guarda en la matriz
            // y empieza la siguiente semana nueva
            if (semanaActual.size() == 7) {
                semanas.add(new ArrayList<>(semanaActual));
                semanaActual.clear();
            }
        }

        // y por ultimo añadimos la última semana si faltan dias
        if (!semanaActual.isEmpty()) {
            while (semanaActual.size() < 7) {
                semanaActual.add("");
            }
            semanas.add(semanaActual);
        }

        // obtenemos el mes en texto para usarlo en el html
        String nombreMes = cal.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, locale);

        model.addAttribute("mes", nombreMes);
        model.addAttribute("anio", anio);
        model.addAttribute("semanas", semanas);

        return "show-month";
    }
}
