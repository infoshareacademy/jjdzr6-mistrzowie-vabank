package com.infoshareacademy.mistrzowieVaBank.service;

import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import com.infoshareacademy.mistrzowieVaBank.repository.WineListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineListServiceImpl implements WineListService {

    @Autowired
    private WineListRepository wineListRepository;

    @Override
    public List<Wine> findAll() {
        return wineListRepository.findAll();
    }

    public Page<Wine> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.wineListRepository.findAll(pageable);
    }
}
