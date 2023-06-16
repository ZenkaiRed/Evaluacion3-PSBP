package com.example.evaluacion3.controllers;

import com.example.evaluacion3.Utils;
import com.example.evaluacion3.dtos.UsuarioDto;
import com.example.evaluacion3.model.Orden;
import com.example.evaluacion3.model.Platillo;
import com.example.evaluacion3.model.Usuario;
import com.example.evaluacion3.services.IOrdenService;
import com.example.evaluacion3.services.UsuarioService;
import org.aspectj.weaver.ast.Or;
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
@RequestMapping(path = "api/usuarios")
public class UsuarioController extends BaseController<Usuario, UsuarioService> {

    @Autowired
    private IOrdenService ordenService;

    @GetMapping("/ordenes")
    public ResponseEntity<?> endpoint1() {
        try{

            List<Usuario> usuarioList = service.findAll();
            List<Orden> ordenList = ordenService.findAll();
            List<UsuarioDto> usuarioDtoList = new ArrayList<>();

            for (Usuario usuario : usuarioList){

                UsuarioDto usuarioDto = new UsuarioDto();
                usuarioDto.setName(usuario.getName());
                usuarioDto.setRut(usuario.getRut());
                List<Orden> userOrdenList = new ArrayList<>();

                for (Orden orden : ordenList){

                    Platillo ordenPlatillo = orden.getPlatillo();
                    Usuario ordenUsuario = orden.getUsuario();

                    if (ordenUsuario.equals(usuario)){
                        usuarioDto.getDishes().add(ordenPlatillo);
                        userOrdenList.add(orden);
                    }
                }

                int contador = Utils.countOrdersLastMonth(userOrdenList);
                usuarioDto.setTotal_sum_last_month(contador);
                usuarioDtoList.add(usuarioDto);
            }

            return ResponseEntity.status(HttpStatus.OK).body(usuarioDtoList);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }


}
