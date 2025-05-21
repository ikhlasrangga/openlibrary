package com.app.OpenLibrary.repository;

import com.app.OpenLibrary.model.Book;
import com.app.OpenLibrary.model.Loan;

import java.text.ParseException;
import java.util.List;

public interface LoanInterface {

    List<Loan> getAllLoanData();
    String bookLoan(Loan loan) throws ParseException;

    List<Loan> getBookLoanByMemberId(String memberId);
    List<Book> getAllBookOnLoan();

    String returnBook(String memberId, String bookId);
}
