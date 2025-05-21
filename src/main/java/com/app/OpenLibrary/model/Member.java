package com.app.OpenLibrary.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Member {
    @NotNull
    @NotBlank
    private String memberId;
    private String name;
    private String dateofbirth;
    private String address;
    private String validUntil;
    private String isActive;
}
