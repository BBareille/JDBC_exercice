package fr.etudejdbc.DAO;

import fr.etudejdbc.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static fr.etudejdbc.App.databaseConnection;

public class EmployesDAO {

    public static Employes find(Integer id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("SELECT * FROM EMPLOYES WHERE idEmploye="+id);
        ResultSet rs = ps.executeQuery();
        Employes employes = new Employes();
        while(rs.next()){
            employes.setId(rs.getInt("idEmploye"));
            employes.setIdPays(rs.getInt("idPays"));
            employes.setIdSociete(rs.getString("idSociete"));
            employes.setIdResponsable(rs.getInt("idResponsable"));
            employes.setNom(rs.getString("Nom"));
            employes.setPrenom(rs.getString("Prenom"));
            employes.setSalaireMensuel(rs.getFloat("SalaireMensuel"));
        }
        return employes;
    }

    public static ArrayList<Employes> findAll() throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("SELECT * FROM EMPLOYES");
        ResultSet rs = ps.executeQuery();
        ArrayList<Employes> employesList = new ArrayList<>();
        while(rs.next()){
            Employes employes = new Employes();
            employes.setId(rs.getInt("idEmploye"));
            employes.setIdPays(rs.getInt("idPays"));
            employes.setIdSociete(rs.getString("idSociete"));
            employes.setIdResponsable(rs.getInt("idResponsable"));
            employes.setNom(rs.getString("Nom"));
            employes.setPrenom(rs.getString("Prenom"));
            employes.setSalaireMensuel(rs.getFloat("SalaireMensuel"));
            employesList.add(employes);
        }
        return employesList;
    }

    public static Employes findWhere(String column, String data) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("SELECT * FROM EMPLOYES WHERE " + column+"= \'"+data+"\'");
        ResultSet rs = ps.executeQuery();
        Employes employes = new Employes();
        while(rs.next()){
            employes.setId(rs.getInt("idEmploye"));
            employes.setIdPays(rs.getInt("idPays"));
            employes.setIdSociete(rs.getString("idSociete"));
            employes.setIdResponsable(rs.getInt("idResponsable"));
            employes.setNom(rs.getString("Nom"));
            employes.setPrenom(rs.getString("Prenom"));
            employes.setSalaireMensuel(rs.getFloat("SalaireMensuel"));
        }
        return employes;
    }

    public static void save(Employes newEmploye) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("INSERT INTO Employes (Nom, Prenom, idPays, idSociete, idResponsable, SalaireMensuel) VALUES ("+
                "\'"+newEmploye.getNom()+ "\',"+
                "\'"+newEmploye.getPrenom()+"\',"+
                "\'"+newEmploye.getIdPays()+"\',"+
                "\'"+newEmploye.getIdSociete()+"\',"+
                "\'"+newEmploye.getIdResponsable()+"\',"+
                "\'"+newEmploye.getSalaireMensuel()+"\'" +
                ")");
        ps.executeUpdate();
    }

    public static void delete(Integer id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("DELETE FROM EMPLOYES WHERE idEmplote=id");
    }

    public static void update(Integer previousId,Employes updatedEmployes) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection()
                .prepareStatement("UPDATE EMPLOYES SET idEmploye="+"\'"+updatedEmployes.getId()+"\'"+"," +
                        " nom="+"\'"+updatedEmployes.getNom()+"\'"+"," +
                        " idPays="+"\'"+ updatedEmployes.getIdPays()+"\'"+"," +
                        " idSociete="+"\'"+ updatedEmployes.getIdSociete()+"\'"+"," +
                        " idResponsable="+"\'"+ updatedEmployes.getIdResponsable()+"\'"+"," +
                        " SalaireMensuel="+"\'"+ updatedEmployes.getSalaireMensuel()+"\'"+"," +
                        " prenom="+"\'"+updatedEmployes.getPrenom()+"\'"+
                        " WHERE idEmploye="+previousId);
        ps.executeUpdate();
    }

    public static void change_salary_and_responsable(Float salary, Integer idReponsable, Integer employeId) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("CALL change_salary_and_responsable("+salary+", "+idReponsable+", "+employeId+")");
        ps.executeUpdate();
    }
}
