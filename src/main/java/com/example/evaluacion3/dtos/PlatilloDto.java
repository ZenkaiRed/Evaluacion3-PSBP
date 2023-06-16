package com.example.evaluacion3.dtos;

import com.example.evaluacion3.model.Usuario;
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
public class PlatilloDto {

    private String name;
    private Integer price;
    private List<Usuario> clients = new ArrayList<>();

}