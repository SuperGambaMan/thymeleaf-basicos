package com.iesvdm.thymeleafbasicos.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuadraticaDTO {
    //DTO = Data Transfer Object, subcategoria de Beans o POJOs
        //para recibir y enviar datos a la vista (capa view)

    //Usamos el NotNull por que no pueden ser Nulos
    @NotNull
    private BigDecimal a;
    @NotNull
    private BigDecimal b;
    @NotNull
    private BigDecimal c;

    private BigDecimal raiz1;
    private BigDecimal raiz2;

}
