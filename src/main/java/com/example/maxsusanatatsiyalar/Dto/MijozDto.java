package com.example.maxsusanatatsiyalar.Dto;

import lombok.Data;

import java.util.List;

@Data
public class MijozDto {
 private Integer id;
 private String viloyat;
 private String tuman;
 private String kocha;
 private String fish;
 private String telNomer;

private List<ManzilDto> manzilDtoList;
}
