package com.sansen.roadmap.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {
    private final UserService userService = new UserService();

    @Test
    void shouldCreateAndFindUser() {
        User created = userService.create(new CreateUserRequest("Alice", 28));
        assertThat(created.id()).isEqualTo(1L);
        assertThat(userService.findById(1L).name()).isEqualTo("Alice");
        assertThat(userService.findAll()).hasSize(1);
    }
}
