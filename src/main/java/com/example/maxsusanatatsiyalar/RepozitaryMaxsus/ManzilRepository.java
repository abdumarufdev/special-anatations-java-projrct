package com.example.maxsusanatatsiyalar.RepozitaryMaxsus;

import com.example.maxsusanatatsiyalar.Entity.Manzil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManzilRepository extends JpaRepository<Manzil,Integer> {

}
