package com.app.OpenLibrary.util;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUpdateStetment implements PreparedStatementCallback<String> {

    @Override
    public String doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
        return String.valueOf(ps.execute());
    }
}
