package com.example.maxsusanatatsiyalar.Servis;

import com.example.maxsusanatatsiyalar.Dto.AypiRespons;
import com.example.maxsusanatatsiyalar.Dto.ManzilDto;
import com.example.maxsusanatatsiyalar.Dto.MijozDto;
import com.example.maxsusanatatsiyalar.Entity.Manzil;
import com.example.maxsusanatatsiyalar.Entity.Mijoz;
import com.example.maxsusanatatsiyalar.RepozitaryMaxsus.ManzilRepository;
import com.example.maxsusanatatsiyalar.RepozitaryMaxsus.MijozRepozitary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MijozServise {
    @Autowired
    MijozRepozitary mijozRepozitary;

    @Autowired
    ManzilRepository manzilRepository;


    public AypiRespons saveManzil(MijozDto malumot) {
        Mijoz mijoz = new Mijoz();
        mijoz.setFish(malumot.getFish());
        mijoz.setTelNomer(malumot.getTelNomer());
        List<Manzil> manzilList=new ArrayList<>();

        for (ManzilDto manzilDto : malumot.getManzilDtoList()) {
            Manzil manzil = new Manzil();
            manzil.setViloyat(manzilDto.getViloyat());
            manzil.setTuman(manzilDto.getTuman());
            manzil.setKocha(manzilDto.getKocha());
            manzil.setMijoz(mijoz);
            manzilList.add(manzil);
        }

        mijoz.setManzilList(manzilList);
        mijozRepozitary.save(mijoz);
        return new AypiRespons("malumot joylandi",true);
    }

    public AypiRespons ochmijoz(Integer id) {
        try {
            mijozRepozitary.deleteById(id);
            return new AypiRespons("ma'lumot ochirildi",true);
        }
        catch (Exception a){
            return new AypiRespons("mijoz mavjud emas ",false);
        }
    }

    public AypiRespons tahMijoz(MijozDto mijozDto, Integer id) {
        Optional<Mijoz> mijozOption=mijozRepozitary.findById(id);
        Mijoz mijoz = mijozOption.get();
        mijoz.setFish(mijozDto.getFish());
        mijoz.setTelNomer(mijozDto.getTelNomer());
        List<Manzil> manzilList=new ArrayList<>();

        int id1= 0;
        for (ManzilDto manzilDto : mijozDto.getManzilDtoList()) {
            List<Manzil> list = manzilRepository.findAll();
            for (Manzil manzil: list){
                if (manzil.getMijoz().getId().equals(id)){
                    if (id1!=manzil.getId()){
                        id1=manzil.getId();
                        break;
                    }
                }
            }
            Optional<Manzil> manzilOptional=manzilRepository.findById(id1);
            Manzil manzil = manzilOptional.get();
            manzil.setViloyat(manzilDto.getViloyat());
            manzil.setTuman(manzilDto.getTuman());
            manzil.setKocha(manzilDto.getKocha());
            manzil.setMijoz(mijoz);
            manzilList.add(manzil);
        }

        mijoz.setManzilList(manzilList);
        mijozRepozitary.save(mijoz);
        return new AypiRespons("malumot tahrirlandi",true);
    }
    public AypiRespons UqiId(Integer id) {
        Optional<Manzil> byId = manzilRepository.findById(id);
        if (byId.isPresent()){
            return new AypiRespons(byId.toString(),true);
        }
        return new AypiRespons("Bunday id mavjud emas",false);
    }




    public AypiRespons Tah2(MijozDto mijozDto, Integer id) {
        Optional<Mijoz> byId = mijozRepozitary.findById(id);
        if (byId.isPresent()){
            Mijoz one = mijozRepozitary.getOne(id);
            one.setFish(mijozDto.getFish());
            one.setTelNomer(mijozDto.getTelNomer());
            List<Manzil> manzilList=new ArrayList<>();
        }

        return null;
    }

}
