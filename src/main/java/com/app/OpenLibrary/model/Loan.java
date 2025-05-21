package com.app.OpenLibrary.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class Loan {
    @NotNull
    @NotBlank
    private String bookId;
    private String title;
    @NotNull
    @NotBlank
    private String memberId;
    private String memberName;
    private String startDate;
    private String endDate;
    private String loanDays;
    private String status;
}