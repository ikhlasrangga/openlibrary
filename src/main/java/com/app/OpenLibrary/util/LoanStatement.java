package com.app.OpenLibrary.util;

import com.app.OpenLibrary.model.Loan;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanStatement implements RowMapper<Loan> {

    @Override
    public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
        Loan loan = new Loan();
        loan.setBookId(rs.getString("book_id"));
        loan.setTitle(rs.getString("title"));
        loan.setMemberId(rs.getString("member_id"));
        loan.setMemberName(rs.getString("name"));
        loan.setStartDate(String.valueOf(rs.getDate("start_date")));
        loan.setEndDate(String.valueOf(rs.getDate("end_date")));
        loan.setLoanDays(rs.getString("loan_days"));
        loan.setStatus(rs.getString("status"));

        return loan;
    }
}
