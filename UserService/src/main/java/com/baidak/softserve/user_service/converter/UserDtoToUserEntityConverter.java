package com.baidak.softserve.user_service.converter;

import com.baidak.softserve.user_service.domain.User;
import com.baidak.softserve.user_service.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserEntityConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        UserDto userDto = new UserDto();
return userDto;
    }
}
