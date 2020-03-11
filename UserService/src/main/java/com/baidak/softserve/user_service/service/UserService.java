package com.baidak.softserve.user_service.service;

import com.baidak.softserve.user_service.domain.User;
import com.baidak.softserve.user_service.dto.UserCreateDTO;
import com.baidak.softserve.user_service.dto.UserDto;
import com.baidak.softserve.user_service.dto.UserReadDTO;
import com.baidak.softserve.user_service.exeption.EntityNotFoundException;
import com.baidak.softserve.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final TranslationService translationService;

    private User getRequiredUser(UUID id) { // TODO OpenConnect
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(User.class, id));
    }

    public UserDto getUser(UUID id) {
        User user = getRequiredUser(id);
        return translationService.toRead(user);
    }

    public UUID createUser(UserDto create) {
        User user = new User();
        user.setName(create.getName());
        user.setSurName(create.getSurName());
        user.setEmail(create.getEmail());
        user.setDateOfBirth(create.getDateOfBirth());
        user = userRepository.save(user);
        return user.getId();
    }
}
