package fr.etudejdbc.model;

import fr.etudejdbc.DAO.SocietesDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employes {

    Integer id;
    String Nom;
    String Prenom;
    Integer idPays;
    String idSociete;
    Integer idResponsable;
    Float salaireMensuel;

    @Override
    public String toString() {
        try {
            return this.getNom() + " " + this.getPrenom() + " de l'entreprise: " + SocietesDAO.find(this.idSociete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public Integer getIdPays() {
        return idPays;
    }

    public void setIdPays(Integer idPays) {
        this.idPays = idPays;
    }

    public String getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(String idSociete) {
        this.idSociete = idSociete;
    }

    public Integer getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Integer idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Float getSalaireMensuel() {
        return salaireMensuel;
    }

    public void setSalaireMensuel(Float salaireMensuel) {
        this.salaireMensuel = salaireMensuel;
    }
}
