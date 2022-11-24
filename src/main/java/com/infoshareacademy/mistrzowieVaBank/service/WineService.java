package com.infoshareacademy.mistrzowieVaBank.service;

import com.infoshareacademy.mistrzowieVaBank.dto.NewWineInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.WineDto;
import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import com.infoshareacademy.mistrzowieVaBank.repository.WineRepository;
import com.infoshareacademy.mistrzowieVaBank.service.mapper.WineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Slf4j
@Service
public class WineService {

    private final WineMapper wineMapper;
    private final WineRepository wineRepository;

    public WineService(WineMapper wineMapper, WineRepository wineRepository) {
        this.wineMapper = wineMapper;
        this.wineRepository = wineRepository;
    }

    @Transactional
    public void createWine(NewWineInfo newWineInfo) {
        Wine wine = wineMapper.toEntity(newWineInfo);
        wineRepository.save(wine);
    }

    @Transactional
    public WineDto find(Long id) {
        Optional<Wine> byId = wineRepository.findById(id);
        log.info("test{}",id);
        return byId
                .map(wineMapper::toDto)
                .orElseThrow(() -> new IllegalStateException("Wine with id not found: " + id));
    }
}
