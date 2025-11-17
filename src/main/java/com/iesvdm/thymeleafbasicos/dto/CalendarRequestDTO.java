package com.iesvdm.thymeleafbasicos.dto;


import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private int anio;

}
