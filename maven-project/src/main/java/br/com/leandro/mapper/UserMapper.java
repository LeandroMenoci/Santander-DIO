package br.com.leandro.mapper;

import br.com.leandro.dto.UserDTO;
import br.com.leandro.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "code", source = "id")
    @Mapping(target = "userName", source = "name")
    UserModel toModel(UserDTO dto);

    @Mapping(target = "id", source = "code")
    @Mapping(target = "name", source = "userName")
    UserDTO toDTO(UserModel model);
}
