package com.sansen.roadmap.user;

import com.sansen.roadmap.common.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ApiResponse<List<User>> findAll() {
        return ApiResponse.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<User> findById(@PathVariable Long id) {
        return ApiResponse.ok(userService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<User> create(@Valid @RequestBody CreateUserRequest request) {
        return ApiResponse.ok(userService.create(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
