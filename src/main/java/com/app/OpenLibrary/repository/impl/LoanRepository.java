package com.app.OpenLibrary.repository.impl;

import com.app.OpenLibrary.model.Book;
import com.app.OpenLibrary.model.Loan;
import com.app.OpenLibrary.repository.LoanInterface;
import com.app.OpenLibrary.util.BookStatement;
import com.app.OpenLibrary.util.InsertUpdateStetment;
import com.app.OpenLibrary.util.LoanStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class LoanRepository implements LoanInterface {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;


    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public List<Loan> getAllLoanData() {
        final String sql = "SELECT l. book_id,b.title, l.member_id, m.name,l.start_date,l.end_date,l.loan_days,l.status FROM public.loan l, public.books b, public.member m" +
                "WHERE l.book_id = b.book_id AND l.member_id = m.member_id";
        return jdbcTemplate.query(sql,new LoanStatement());
    }

    @Override
    public String bookLoan(Loan loan) throws ParseException {
       final String sql = "INSERT INTO public.loan (end_date, loan_days, start_date, status, book_id, member_id) VALUES(:endDate, :loanDays, :startDate, :status, :bookId, :memberId)";
       SqlParameterSource param = new MapSqlParameterSource()
                .addValue("endDate",formatter.parse(loan.getEndDate()))
                .addValue("loanDays",loan.getLoanDays())
                .addValue("startDate",formatter.parse(loan.getStartDate()))
                .addValue("status",loan.getStatus())
                .addValue("bookId",loan.getBookId())
                .addValue("memberId",loan.getMemberId());

       return jdbcTemplate.execute(sql,param, new InsertUpdateStetment());
    }

    @Override
    public List<Loan> getBookLoanByMemberId(String memberId) {
        final String sql = "SELECT l.book_id,b.title, l.member_id, m.name,l.start_date,l.end_date,l.loan_days,l.status FROM public.loan l, public.books b, public.member m where l.book_id = b.book_id and l.member_id = :memberId";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("memberId",memberId);
        return jdbcTemplate.query(sql,param,new LoanStatement());
    }

    @Override
    public List<Book> getAllBookOnLoan() {
        final String sql = "SELECT b.book_id,b.isbn, b.title, b.author, b.published_time from public.books b, public.loan l where b.book_id = l.book_id and l.status = 'loan'";

        return jdbcTemplate.query(sql,new BookStatement());
    }

    @Override
    public String returnBook(String memberId, String bookId) {
        final String sql = "DELETE FROM public.loan WHERE book_id = :bookId AND member_id = :memberId";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("bookId",bookId)
                .addValue("memberId",memberId);

        return jdbcTemplate.execute(sql,param, new InsertUpdateStetment());
    }
}
