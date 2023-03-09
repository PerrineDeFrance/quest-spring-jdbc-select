package com.wildcodeschool.wildandwizard.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wildcodeschool.wildandwizard.entity.School;


public class SchoolRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/spring_jdbc_quest?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public List<School> findAll() {

        
    try {
Connection connection = DriverManager.getConnection(
                            DB_URL, DB_USER, DB_PASSWORD
                    );
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM school;"
                    );
                    ResultSet resultSet = statement.executeQuery();
        
                    List<School> schools = new ArrayList<>();
        
                    while (resultSet.next()) {
                        Long id = resultSet.getLong("id");
                        String name = resultSet.getString("name");
                        int capacity = resultSet.getInt("capacity");
                        String country = resultSet.getString("country");
                        
                        schools.add(new School(id,name,capacity,country));
                    };
                    return schools;
                } catch (
                        SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        
        

    public School findById() {

        try {
            Connection connection = DriverManager.getConnection(
                                        DB_URL, DB_USER, DB_PASSWORD
                                );
                                PreparedStatement statement = connection.prepareStatement(
                                        "SELECT id FROM school WHERE id=?;"
                                );
                                statement.setLong(1,id);
                                ResultSet resultSet = statement.executeQuery();
                    
                                List<School> schools = new ArrayList<>();
                    
                                if (resultSet.next()) {
                                    Long id=resultSet.getLong("id");
                                    String name = resultSet.getString("name");
                                    int capacity = resultSet.getInt("capacity");
                                    String country = resultSet.getString("country");
                        
                                    return new School(id, name, capacity, country);
                                   
                                };
                                
                            } catch (
                                    SQLException e) {
                                e.printStackTrace();
                            }{
                            return null;
                        }
                
    }
    

    public List<School> findByCountry() {

        try {
            Connection connection = DriverManager.getConnection(
                                        DB_URL, DB_USER, DB_PASSWORD
                                );
                                PreparedStatement statement = connection.prepareStatement(
                                        "SELECT country FROM school;"
                                );
                                ResultSet resultSet = statement.executeQuery();
                    
                                List<School> schools = new ArrayList<>();
                    
                                while (resultSet.next()) {
                                    Long id = resultSet.getLong("id");
                                    String name = resultSet.getString("name");
                                    int capacity = resultSet.getInt("capacity");
                                   String country=resultSet.getString("country");
                                    
                                    schools.add(new School(id,name,capacity,country));
                                };
                                return schools;
                            } catch (
                                    SQLException e) {
                                e.printStackTrace();
                            }
                            return null;
                        
                        }



}
    

