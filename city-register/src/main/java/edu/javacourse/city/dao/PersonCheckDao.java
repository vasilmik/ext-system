package edu.javacourse.city.dao;

import edu.javacourse.city.config.Config;
import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;

import java.sql.*;

public class PersonCheckDao {

    public static final String SQL_REQUEST = "select * from cr_address_person cr_ap " +
            "inner join cr_person p on cr_ap.person_id = p.person_id " +
            "inner join cr_address ca on cr_ap.address_id = ca.address_id " +
            "where p.sur_name = ? and p.given_name = ? and p.patronymic = ?  " +
            "and p.date_of_birth = ?  " +
            "and ca.street_code = ? and ca.building = ? and ca.extension = ? and ca.apartment = ?";

    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {

         PersonResponse response = new PersonResponse();

         try (Connection con = getConnection();
              PreparedStatement stmt = con.prepareStatement(SQL_REQUEST)) {

             stmt.setString(1,request.getSurName());
             stmt.setString(2,request.getGivenName());
             stmt.setString(3,request.getPatronymic());
             stmt.setDate(4,Date.valueOf(request.getDateOfBitch()));
             stmt.setInt(5,1);
             stmt.setString(6,request.getBuilding());
             stmt.setString(7,request.getExtension());
             stmt.setString(8,request.getApartment());

             ResultSet set = stmt.executeQuery();

             if (set.next()){
                 response.setRegistered(true);
                 response.setTemporal(set.getBoolean("temporal"));
             }

         } catch (SQLException throwables) {
             throw new PersonCheckException(throwables);
         }

         return response;
     }

    private Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return con;
    }

}
