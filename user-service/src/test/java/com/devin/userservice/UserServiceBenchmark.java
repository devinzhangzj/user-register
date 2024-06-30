package com.devin.userservice;

import com.devin.userservice.model.User;
import com.devin.userservice.repository.UserRepository;
import com.devin.userservice.service.UserServiceImpl;
import org.openjdk.jmh.annotations.*;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@State(Scope.Benchmark)
public class UserServiceBenchmark {

    private UserServiceImpl userService;
    private UserRepository userRepository;

    @Setup
    public void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl();
        userService.setUserRepository(userRepository);

        // Prepare mock data
        User user = new User();
        user.setId(1L);
        user.setUserName("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("password123");
        user.setActive(true);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getUserByIdBenchmark() {
        userService.getUserById(1L);
    }

    @TearDown
    public void tearDown() {
        // Cleanup if needed
    }
}
