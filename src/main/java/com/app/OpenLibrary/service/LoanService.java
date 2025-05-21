package com.app.OpenLibrary.service;

import com.app.OpenLibrary.model.Book;
import com.app.OpenLibrary.model.Loan;
import com.app.OpenLibrary.model.Response;
import com.app.OpenLibrary.repository.impl.LoanRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class LoanService {

    @Resource
    LoanRepository loanRepository;

    public Response getAllLoanData(){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        try{
            List<Loan> result = loanRepository.getAllLoanData();
            response.setData(result);
            log.info("Success get All loan data with result : "+result);
        }catch (Exception e){

            String result = e.getMessage();
            if(result.contains("ERROR:") && result.contains("Detail:")){

                response.setResponseCode("06");
                response.setResponseDesc("Failed");

                List<String> errorReason= new ArrayList<>();

                int startIdx = result.indexOf("ERROR:");
                int endIdx = result.indexOf("Detail:");

                String error = result.substring(startIdx,endIdx);
                String reason = result.substring(endIdx);

                errorReason.add(error);
                errorReason.add(reason);

                response.setData(errorReason);

            }else{
                response.setResponseCode("99");
                response.setResponseDesc(e.getLocalizedMessage());
            }
        }

        return response;
    }

    public Response getAllBookOnLoan(){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        try{
            List<Book> result = loanRepository.getAllBookOnLoan();
            response.setData(result);
            log.info("Success get book on loan data with result : "+result);
        }catch (Exception e){

            String result = e.getMessage();
            if(result.contains("ERROR:") && result.contains("Detail:")){

                response.setResponseCode("06");
                response.setResponseDesc("Failed");

                List<String> errorReason= new ArrayList<>();

                int startIdx = result.indexOf("ERROR:");
                int endIdx = result.indexOf("Detail:");

                String error = result.substring(startIdx,endIdx);
                String reason = result.substring(endIdx);

                errorReason.add(error);
                errorReason.add(reason);

                response.setData(errorReason);

            }else{
                response.setResponseCode("99");
                response.setResponseDesc(e.getLocalizedMessage());
            }
        }

        return response;
    }

    public Response loanBook(Loan loan){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        boolean sign = false;

        String bookId = loan.getBookId();

        try{
            List<Book> result = loanRepository.getAllBookOnLoan();

            for(Book book:result){
                if(bookId.equalsIgnoreCase(book.getBookId())){
                    sign = true;
                }
            }

            if (sign == false){
                String result1 = loanRepository.bookLoan(loan);
                log.info("Success input loan data with result : "+result1);
            }else{
                response.setResponseCode("01");
                response.setResponseDesc("Success");
                response.setData("Book On Loan");
            }

            log.info("Success get book on loan data with result : "+result);
        }catch (Exception e){

            String result = e.getMessage();
            if(result.contains("ERROR:") && result.contains("Detail:")){

                response.setResponseCode("06");
                response.setResponseDesc("Failed");

                List<String> errorReason= new ArrayList<>();

                int startIdx = result.indexOf("ERROR:");
                int endIdx = result.indexOf("Detail:");

                String error = result.substring(startIdx,endIdx);
                String reason = result.substring(endIdx);

                errorReason.add(error);
                errorReason.add(reason);

                response.setData(errorReason);

            }else{
                response.setResponseCode("99");
                response.setResponseDesc(e.getLocalizedMessage());
            }
        }

        return response;
    }


    public Response getBookLoanByMember(String memberId){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        try{
            List<Loan> result = loanRepository.getBookLoanByMemberId(memberId);
            response.setData(result);
            log.info("Success get book on loan data with result : "+result);
        }catch (Exception e){

            String result = e.getMessage();
            if(result.contains("ERROR:") && result.contains("Detail:")){

                response.setResponseCode("06");
                response.setResponseDesc("Failed");

                List<String> errorReason= new ArrayList<>();

                int startIdx = result.indexOf("ERROR:");
                int endIdx = result.indexOf("Detail:");

                String error = result.substring(startIdx,endIdx);
                String reason = result.substring(endIdx);

                errorReason.add(error);
                errorReason.add(reason);

                response.setData(errorReason);

            }else{
                response.setResponseCode("99");
                response.setResponseDesc(e.getLocalizedMessage());
            }
        }

        return response;
    }

    public Response returnBook(String memberId,String bookId){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        try{
            String result = loanRepository.returnBook(memberId,bookId);
            log.info("Success return book with result : "+result);
        }catch (Exception e){

            String result = e.getMessage();
            if(result.contains("ERROR:") && result.contains("Detail:")){

                response.setResponseCode("06");
                response.setResponseDesc("Failed");

                List<String> errorReason= new ArrayList<>();

                int startIdx = result.indexOf("ERROR:");
                int endIdx = result.indexOf("Detail:");

                String error = result.substring(startIdx,endIdx);
                String reason = result.substring(endIdx);

                errorReason.add(error);
                errorReason.add(reason);

                response.setData(errorReason);

            }else{
                response.setResponseCode("99");
                response.setResponseDesc(e.getLocalizedMessage());
            }
        }

        return response;
    }

}
