package com.infoshareacademy.mistrzowieVaBank.service.mapper;

import com.infoshareacademy.mistrzowieVaBank.dto.NewWineInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.OrderDetailInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.WineDto;
import com.infoshareacademy.mistrzowieVaBank.entity.OrderDetail;
import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class OrderMapper {

    public OrderDetailInfo toEntity(OrderDetail orderDetail) {
        OrderDetailInfo order = new OrderDetailInfo();
        order.setAmount(orderDetail.getAmount());
        order.setPrice(orderDetail.getPrice());
        order.setQuantity(orderDetail.getQuantity());
        order.setWineName(orderDetail.getWine().getName());
        return order;
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
