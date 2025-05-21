package com.app.OpenLibrary.service;

import com.app.OpenLibrary.model.Book;
import com.app.OpenLibrary.model.Member;
import com.app.OpenLibrary.model.Response;
import com.app.OpenLibrary.repository.impl.BookRepository;
import com.app.OpenLibrary.repository.impl.MemberRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MemberService {

    @Resource
    MemberRepository memberRepository;

    public Response insertMemberData(Member member){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        try{
            String result = memberRepository.insertMemberData(member);
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

    public Response updateMemberData(Member member){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        try{
            String result = memberRepository.updateMemberData(member);
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

    public Response getAllActiveMember(){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        try{
            List<Member> result = memberRepository.getAllActiveMember();
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

    public Response getAllInactiveMember(){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        try{
            List<Member> result = memberRepository.getAllInactiveMember();
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

    public Response getMemberById(String id){
        Response response = new Response();
        response.setResponseCode("00");
        response.setResponseDesc("Success");
        response.setData("");

        try{
            List<Member> result = memberRepository.getMemberById(id);
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
