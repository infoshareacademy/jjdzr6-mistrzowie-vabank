package com.infoshareacademy.mistrzowieVaBank.service.mapper;

import com.infoshareacademy.mistrzowieVaBank.dto.NewWineInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.WineDto;
import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class WineMapper {

    public Wine toEntity(NewWineInfo newWineInfo) {
        Wine wine = new Wine();
        wine.setName(newWineInfo.getName());
        wine.setFlavour(newWineInfo.getFlavour());
        wine.setType(newWineInfo.getType());
        wine.setYear(newWineInfo.getYear());
        wine.setOrigin(newWineInfo.getOrigin());
        wine.setPrice(newWineInfo.getPrice());
        wine.setQuantity(newWineInfo.getQuantity());
        wine.setSpec(newWineInfo.getSpec());
        wine.setCreateDate(LocalDate.now());
        wine.setImage(newWineInfo.getFile());
        return wine;
    }

    public WineDto toDto(Wine wine) {
        WineDto dto = new WineDto();
        dto.setName(wine.getName());
        dto.setFlavour(wine.getFlavour());
        dto.setType(wine.getType());
        dto.setYear(wine.getYear());
        dto.setOrigin(wine.getOrigin());
        dto.setPrice(wine.getPrice());
        dto.setQuantity(wine.getQuantity());
        dto.setSpec(wine.getSpec());
        dto.setCreateDate(wine.getCreateDate());
        dto.setImage(wine.getImage());
        return dto;
    }
}
