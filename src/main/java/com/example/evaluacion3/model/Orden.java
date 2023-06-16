package com.example.evaluacion3.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orden")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Orden extends Base{

    private LocalDate order_at;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "id_platillo", referencedColumnName = "id")
    private Platillo platillo;



}
