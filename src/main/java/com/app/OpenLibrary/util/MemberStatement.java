package com.app.OpenLibrary.util;

import com.app.OpenLibrary.model.Member;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberStatement implements RowMapper<Member> {
    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        Member member = new Member();
        member.setMemberId(rs.getString("member_id"));
        member.setName(rs.getString("name"));
        member.setAddress(rs.getString("address"));
        member.setDateofbirth(String.valueOf(rs.getDate("dateofbirth")));
        member.setValidUntil(String.valueOf(rs.getDate("valid_until")));
        member.setIsActive(String.valueOf(rs.getBoolean("is_active")));

        return member;
    }
}
