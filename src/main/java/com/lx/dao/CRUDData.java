package com.lx.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;


@Component("crudData")
public class CRUDData {
    static Logger log = Logger.getLogger(CRUDData.class);

    @Autowired
    private DataSource dataSource;
    static ResultSet result = null;

    public int selectData(String sql,String flag) throws SQLException, IOException, ClassNotFoundException {
        int value = -1;

        Connection con = dataSource.getConnection();
        Statement statement = con.createStatement();
        result = statement.executeQuery(sql);

        if (result.next()) { //如果存在多个值，只取第一个
            value = result.getInt("id");
        }
        log.info(sql+"取值为："+ value);

        if (result != null) {
            result.close();
        }

        return value;
    }

    //新增，修改，删除
    public void cUDData(String sql,String flag) throws SQLException, IOException, ClassNotFoundException {

        Connection con = dataSource.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.executeUpdate();

        log.info("新增/修改/删除语句："+sql);

        if (con != null){
            preparedStatement.close();
            con.close();
        }

    }
}
