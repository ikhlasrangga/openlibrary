package com.app.OpenLibrary.repository;

import com.app.OpenLibrary.model.Book;
import com.app.OpenLibrary.model.Member;

import java.text.ParseException;
import java.util.List;

public interface MemberInterface {

    String insertMemberData(Member member) throws ParseException;

    String updateMemberData(Member member) throws ParseException;
    List<Member> getAllActiveMember();
    List<Member> getAllInactiveMember();
    List<Member> getMemberById(String id);
}
