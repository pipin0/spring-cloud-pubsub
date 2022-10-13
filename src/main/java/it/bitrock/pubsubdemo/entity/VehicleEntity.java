package it.bitrock.pubsubdemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fantastic_table")
public class VehicleEntity implements Serializable {
    @Id
    private Long id;
    private String brand;
    private String model;
    private String color;
}
