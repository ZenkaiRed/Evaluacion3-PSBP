package com.example.evaluacion3.controllers;

import com.example.evaluacion3.dtos.PlatilloDto;
import com.example.evaluacion3.model.Orden;
import com.example.evaluacion3.model.Platillo;
import com.example.evaluacion3.model.Usuario;
import com.example.evaluacion3.services.IOrdenService;
import com.example.evaluacion3.services.PlatilloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/platillos")
public class PlatilloController extends BaseController<Platillo, PlatilloService> {

    @Autowired
    private IOrdenService ordenService;


    @GetMapping("/ordenes")
    public ResponseEntity<?> endpoint2() {
        try{

            List<Platillo> platilloList = service.findAll();
            List<Orden> ordenList = ordenService.findAll();
            List<PlatilloDto> platilloDtoList = new ArrayList<>();

            for (Platillo platillo : platilloList){

                PlatilloDto platilloDto = new PlatilloDto();
                platilloDto.setName(platillo.getName());
                platilloDto.setPrice(platillo.getPrice());

                for (Orden orden : ordenList){

                    Platillo ordenPlatillo = orden.getPlatillo();
                    Usuario usuario = orden.getUsuario();

                    if (ordenPlatillo.equals(platillo)){
                        platilloDto.getClients().add(usuario);
                    }

                }

                platilloDtoList.add(platilloDto);

            }

            return ResponseEntity.status(HttpStatus.OK).body(platilloDtoList);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

}
