package com.example.maxsusanatatsiyalar.Controller;

import com.example.maxsusanatatsiyalar.Dto.AypiRespons;
import com.example.maxsusanatatsiyalar.Dto.ManzilDto;
import com.example.maxsusanatatsiyalar.Dto.MijozDto;
import com.example.maxsusanatatsiyalar.Entity.Mijoz;
import com.example.maxsusanatatsiyalar.RepozitaryMaxsus.MijozRepozitary;
import com.example.maxsusanatatsiyalar.Servis.MijozServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joylash")
public class Controller {
  @Autowired
   MijozServise mijozServise;

   /* @PostMapping("/joylash2")
    public HttpEntity<?> Mijoz(@RequestBody MijozDto userDto){
        AypiRespons aypiRespons=servise.registr1(userDto);
       return ResponseEntity.status(aypiRespons.isHolat()?200:208).body(aypiRespons.getXabar());
    }*/

    @PostMapping("/manzil")
    public HttpEntity<?> manzilsave(@RequestBody MijozDto mijozDto){
        AypiRespons aypiRespons = mijozServise.saveManzil(mijozDto);
       return ResponseEntity.status(aypiRespons.isHolat()?200:208).body(aypiRespons.getXabar());
   }
   @DeleteMapping("/ochirish/{id}")
    public HttpEntity<?> Ochirish(@PathVariable Integer id){
       AypiRespons aypiRespons=mijozServise.ochmijoz(id);
       return ResponseEntity.status(aypiRespons.isHolat()?200:208).body(aypiRespons.getXabar());
   }
   @PutMapping("/Tahrirlash/{id}")
    public HttpEntity<?> Tahrirla(@RequestBody MijozDto mijozDto, @PathVariable Integer id){
       AypiRespons aypiRespons=mijozServise.tahMijoz(mijozDto,id);
       return ResponseEntity.status(aypiRespons.isHolat()?200:208).body(aypiRespons.getXabar());
   }
    @PutMapping("/TahrirlashIkkinchiYol/{id}")
    public HttpEntity<?> Tah2(@RequestBody MijozDto mijozDto, @PathVariable Integer id){
        AypiRespons aypiRespons=mijozServise.Tah2(mijozDto,id);
        return ResponseEntity.status(aypiRespons.isHolat()?200:208).body(aypiRespons.getXabar());
    }
   @GetMapping("/uqish/{id}")
    public HttpEntity<?> Uqish(@PathVariable Integer id){
        AypiRespons aypiRespons=mijozServise.UqiId(id);
       return ResponseEntity.status(aypiRespons.isHolat()?200:208).body(aypiRespons.getXabar());
   }








}
