package com.app.OpenLibrary.controller;


import com.app.OpenLibrary.model.Member;
import com.app.OpenLibrary.model.Response;
import com.app.OpenLibrary.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(value={"/openlibrary/v1/member"})
public class MemberController {


    @Autowired
    MemberService memberService;



    @PostMapping("/insert")
    public ResponseEntity<Response> insert(@Valid  @RequestBody Member member){
        Response response = new Response();

        response = memberService.insertMemberData(member);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/update")
    public ResponseEntity<Response> update(@Valid @RequestBody Member member){
        Response response = new Response();

        response = memberService.updateMemberData(member);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/active")
    public ResponseEntity<Response> getAllActiveMember(){
        Response response = new Response();

        response = memberService.getAllActiveMember();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/inactive")
    public ResponseEntity<Response> getAllInactiveMember(){
        Response response = new Response();

        response = memberService.getAllInactiveMember();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getMemberById(@PathVariable String id){
        Response response = new Response();

        response = memberService.getMemberById(id);

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
