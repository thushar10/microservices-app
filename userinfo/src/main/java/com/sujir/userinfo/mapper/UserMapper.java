package com.sujir.userinfo.mapper;

import com.sujir.userinfo.dto.UserDto;
import com.sujir.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User mapUserDTOToUser(UserDto userDto);
    UserDto mapUserToUserDto(User user);
}