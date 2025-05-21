package com.app.OpenLibrary.repository.impl;

import com.app.OpenLibrary.model.Member;
import com.app.OpenLibrary.repository.MemberInterface;
import com.app.OpenLibrary.util.InsertUpdateStetment;
import com.app.OpenLibrary.util.MemberStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class MemberRepository implements MemberInterface {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String insertMemberData(Member member) throws ParseException {
        final String sql = "INSERT INTO public.member (member_id, address, dateofbirth, is_active, name, valid_until) VALUES(:memberId, :address, :dateofbirth, :isActive, :name, :validUntil);";

        String memberId = member.getMemberId();
        String name = member.getName();
        String address = member.getAddress();
        Date dateofbirth = formatter.parse(member.getDateofbirth());
        Date validUntil = formatter.parse(member.getValidUntil());
        boolean isActive = Boolean.parseBoolean(member.getIsActive());

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("memberId",memberId)
                .addValue("address",address)
                .addValue("dateofbirth",dateofbirth)
                .addValue("isActive",isActive)
                .addValue("name",name)
                .addValue("validUntil",validUntil);



        return jdbcTemplate.execute(sql,param, new InsertUpdateStetment());
    }

    @Override
    public String updateMemberData(Member member) throws ParseException {
        final String sql = "UPDATE public.member SET address=:address, dateofbirth=:dateofbirth, is_active=:isActive, name=:name,valid_until=:validUntil,modified_time=now() WHERE member_id=:memberId";

        String memberId = member.getMemberId();
        String name = member.getName();
        String address = member.getAddress();
        Date dateofbirth = formatter.parse(member.getDateofbirth());
        Date validUntil = formatter.parse(member.getValidUntil());
        boolean isActive = Boolean.parseBoolean(member.getIsActive());

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("memberId",memberId)
                .addValue("address",address)
                .addValue("dateofbirth",dateofbirth)
                .addValue("isActive",isActive)
                .addValue("name",name)
                .addValue("validUntil",validUntil);



        return jdbcTemplate.execute(sql,param, new InsertUpdateStetment());
    }

    @Override
    public List<Member> getAllActiveMember() {
        final String sql = "SELECT*FROM PUBLIC.MEMBER WHERE is_active = 'true'";
        return jdbcTemplate.query(sql,new MemberStatement());
    }

    @Override
    public List<Member> getAllInactiveMember() {
        final String sql = "SELECT*FROM PUBLIC.MEMBER WHERE is_active = 'false'";
        return jdbcTemplate.query(sql,new MemberStatement());
    }

    @Override
    public List<Member> getMemberById(String id) {
        final String sql = "SELECT*FROM PUBLIC.MEMBER WHERE member_id = :memberId";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("memberId",id);

        return jdbcTemplate.query(sql,param,new MemberStatement());
    }
}
