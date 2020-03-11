package com.baidak.softserve.user_service.service;

import com.baidak.softserve.user_service.domain.User;
import com.baidak.softserve.user_service.dto.UserDto;
import com.baidak.softserve.user_service.dto.UserReadDTO;
import org.springframework.stereotype.Service;

@Service
public class TranslationService { //  TODO Converter Spring

    public UserDto toRead(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurName(user.getSurName());
        dto.setDateOfBirth(user.getDateOfBirth());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
