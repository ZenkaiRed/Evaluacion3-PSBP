package com.example.evaluacion3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "platillo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Platillo extends Base{

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    public Integer price;

}
