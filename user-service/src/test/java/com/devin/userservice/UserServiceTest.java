package com.devin.userservice;

import com.devin.userservice.dto.UserDTO;
import com.devin.userservice.model.User;
import com.devin.userservice.repository.UserRepository;
import com.devin.userservice.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

  @InjectMocks
  private UserServiceImpl userService;

  @Mock
  private UserRepository userRepository;

  @Mock
  private RestTemplate restTemplate;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void registerUserWhenUserNameIsUnique() {
    UserDTO userDTO = new UserDTO(null, "newuser", "password123", "newuser@example.com");

    when(userRepository.findByUserName(userDTO.getUserName())).thenReturn(Optional.empty());
    when(restTemplate.postForObject(anyString(), any(), eq(String.class))).thenReturn("Success");

    User user = new User();
    user.setId(1L);
    user.setUserName(userDTO.getUserName());
    user.setEmail(userDTO.getEmail());
    user.setPassword(userDTO.getPassword());
    user.setActive(true);

    when(userRepository.save(any(User.class))).thenReturn(user);

    UserDTO result = userService.registerUser(userDTO);

    assertNotNull(result);
    assertEquals("newuser", result.getUserName());
    assertEquals("newuser@example.com", result.getEmail());
    verify(userRepository, times(1)).findByUserName(userDTO.getUserName());
    verify(userRepository, times(1)).save(any(User.class));
  }

  @Test
  void registerUserShouldThrowExceptionWhenUserNameIsNotUnique() {
    UserDTO userDTO = new UserDTO(null, "existinguser", "existinguser@example.com", "password123");
    User existingUser = new User();
    existingUser.setUserName("existinguser");

    when(userRepository.findByUserName(userDTO.getUserName())).thenReturn(
        Optional.of(existingUser));

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      userService.registerUser(userDTO);
    });

    assertEquals("Username already exists", exception.getMessage());
    verify(userRepository, times(1)).findByUserName(userDTO.getUserName());
    verify(userRepository, times(0)).save(any(User.class));
  }
}
