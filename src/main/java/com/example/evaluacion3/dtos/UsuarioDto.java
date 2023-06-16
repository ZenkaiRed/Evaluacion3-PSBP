package com.example.evaluacion3.dtos;

import com.example.evaluacion3.model.Platillo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDto {

    private String name;
    private String rut;
    private Integer total_sum_last_month;
    List<Platillo> dishes = new ArrayList<>();

}