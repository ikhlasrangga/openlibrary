package com.app.OpenLibrary.service;

import com.app.OpenLibrary.model.Book;
import com.app.OpenLibrary.model.Response;
import com.app.OpenLibrary.repository.impl.BookRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookService {

    @Resource
    BookRepository bookRepository;

    public Response insertBookData(Book book){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        try{
            String result = bookRepository.insertBookData(book);
            log.info("Success insert data with result : "+result);
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

    public Response updateBookData(Book book){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        try{
            String result = bookRepository.updateBookData(book);
            log.info("Success update data with result : "+result);
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

    public Response getAllBookData(){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        try{
            List<Book> result = bookRepository.getAllBook();
            response.setData(result);
            log.info("Success getAll data with result : "+result);
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

    public Response getBookDataByAuthor(String author){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        try{
            List<Book> result = bookRepository.getBookByAuthor(author);
            response.setData(result);
            log.info("Success get data by author with result : "+result);
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
