package com.iesvdm.thymeleafbasicos.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculadoraDTO {
    //DTO = Data Transfer Object, subcategoria de Beans o POJOs
        //para recibir y enviar datos a la vista (capa view)

    private double nota1;
    private double nota2;
    private double nota3;

}
