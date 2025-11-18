package com.iesvdm.thymeleafbasicos.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalendarRequestDTO {
    //DTO = Data Transfer Object, subcategoria de Beans o POJOs
        //para recibir y enviar datos a la vista (capa view)

    @NotEmpty
    private String mes;
    //int no se puede validar con NotEmpty
    // con @Min nos aseguramos que el año tiene que ser mayor que 0
    @Min(value = 0)
    private int anio;

}
