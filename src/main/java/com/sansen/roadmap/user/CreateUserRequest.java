package com.sansen.roadmap.user;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequest(
        @NotBlank String name,
        @NotNull @Min(1) @Max(150) Integer age
) {
}
