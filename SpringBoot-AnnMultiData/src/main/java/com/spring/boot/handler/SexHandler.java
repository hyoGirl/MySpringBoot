package com.spring.boot.handler;

import com.spring.boot.enums.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2020/1/4 10:29
 * @Version 1.0
 */
@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class SexHandler implements TypeHandler<String> {
    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {

        ps.setInt(i, SexEnum.getCodeByName(parameter));
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {

        int anInt = rs.getInt(columnName);

        return SexEnum.getNameByCode(anInt);
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {

        int anInt = rs.getInt(columnIndex);

        return SexEnum.getNameByCode(anInt);
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int anInt = cs.getInt(columnIndex);

        return SexEnum.getNameByCode(anInt);
    }
}
