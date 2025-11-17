package com.iesvdm.thymeleafbasicos.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfiguradorDTO {
    //DTO = Data Transfer Object, subcategoria de Beans o POJOs
        //para recibir y enviar datos a la vista (capa view)


    private String colorTapiceria;

    private String moldura;

}
