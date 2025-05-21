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
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String memberId;
    @NotNull
    @NotBlank
    private String memberName;
    private Date startDate;
    private Date endDate;
    private String loanDays;
    private String status;
}