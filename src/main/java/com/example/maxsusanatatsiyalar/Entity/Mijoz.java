package com.example.maxsusanatatsiyalar.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.nio.MappedByteBuffer;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Mijoz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String fish;
    @Column(nullable = false)
    private String TelNomer;

    @OneToMany(mappedBy ="mijoz",cascade = CascadeType.ALL)
    private List<Manzil> manzilList;





}
