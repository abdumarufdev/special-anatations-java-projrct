package com.example.maxsusanatatsiyalar.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Manzil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String Viloyat;
    @Column(nullable = false)
    private String Tuman;
    @Column(nullable = false)
    private String Kocha;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Mijoz mijoz;

}
