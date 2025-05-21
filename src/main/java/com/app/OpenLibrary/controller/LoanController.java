package com.app.OpenLibrary.controller;


import com.app.OpenLibrary.model.Loan;
import com.app.OpenLibrary.model.Member;
import com.app.OpenLibrary.model.Response;
import com.app.OpenLibrary.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value={"/openlibrary/v1/loan"})
public class LoanController {


    @Autowired
    LoanService loanService;



    @PostMapping()
    public ResponseEntity<Response> loanBook(@Valid  @RequestBody Loan loan){
        Response response = new Response();

        response = loanService.loanBook(loan);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/return")
    public ResponseEntity<Response> returnBook(@Valid @RequestBody Loan loan){
        Response response = new Response();
        String bookId = loan.getBookId();
        String memberId = loan.getMemberId();

        response = loanService.returnBook(memberId,bookId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Response> getAllBookLoanBymemberId(@PathVariable String memberId){
        Response response = new Response();

        response = loanService.getBookLoanByMember(memberId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getAllLoandata(){
        Response response = new Response();

        response = loanService.getAllLoanData();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/bookOnLoan")
    public ResponseEntity<Response> bookOnLoan(){
        Response response = new Response();

        response = loanService.getAllBookOnLoan();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Response> handleMandatoryException(MethodArgumentNotValidException ex) {
        Response response = new Response();
        response.setResponseCode("06");
        response.setResponseDesc("Failed");
        response.setData(ex.getDetailMessageArguments());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
