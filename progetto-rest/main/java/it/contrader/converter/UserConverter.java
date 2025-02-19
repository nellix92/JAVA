package it.contrader.converter;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractConverter<User, UserDTO> {
    @Override
    public User toEntity(UserDTO userDTO) {
        return userDTO != null ? User.builder()
                .id(userDTO.getId())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .usertype(userDTO.getUsertype())
                .build() : null;
    }
    @Override
    public UserDTO toDTO(User user) {
        return user != null ? UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .usertype(user.getUsertype())
                .build() : null;
    }
    public Page<UserDTO> toDTOPage(Page<User> userPage){
        return userPage.map(this::toDTO);
    }
}