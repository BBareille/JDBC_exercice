package fr.etudejdbc.model;

import fr.etudejdbc.DAO.PaysDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static fr.etudejdbc.App.databaseConnection;

public class Societes  {
    String idSociete;
    String name;
    Integer idPays;
    @Override
    public String toString() {
        try {
            return getName() + " se situant dans le pays :" + PaysDAO.find(idPays);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(String idSociete) {
        this.idSociete = idSociete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdPays() {
        return idPays;
    }

    public void setIdPays(Integer idPays) {
        this.idPays = idPays;
    }
}
