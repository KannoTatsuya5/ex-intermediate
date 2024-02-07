package com.example.exintermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exintermediate.model.Hotel;
import com.example.exintermediate.repository.HotelRepository;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> showLessPriceHotel(String price) {
        if (price.isEmpty()) {
			return hotelRepository.findHotel();
		} else {
			return hotelRepository.findHotelLessPrice(Integer.parseInt(price));
		}
    }
}
