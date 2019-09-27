package com.lx.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");

            String sql = "SELECT * FROM athena_loan_handle WHERE id = 24";
            CRUDData crudData = (CRUDData) context.getBean("crudData");
            System.out.println(crudData.selectData(sql,""));
        } catch (IOException e) {

        } catch (SQLException e1) {

        } catch (ClassNotFoundException e2) {

        }
    }
}
