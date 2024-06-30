package com.devin.userservice.service;


import com.devin.userservice.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);

    Optional<UserDTO> getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(Long id, UserDTO userDetails);

    void deleteUser(Long id);
}