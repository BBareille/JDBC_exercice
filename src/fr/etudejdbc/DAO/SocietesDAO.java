package fr.etudejdbc.DAO;

import fr.etudejdbc.model.Societes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static fr.etudejdbc.App.databaseConnection;

public class SocietesDAO {

    public static Societes find(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("SELECT * FROM SOCIETES WHERE idSociete LIKE "+ "\'"+id+"\'");
        ResultSet rs = ps.executeQuery();
        Societes societe = new Societes();
        while(rs.next()){
            societe.setIdSociete(rs.getString("idSociete"));
            societe.setName(rs.getString("Societe"));
            societe.setIdPays(rs.getInt("idPays"));
        }
        return societe;
    }

    public static Societes findWhere(String column, String data) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("SELECT * FROM SOCIETES WHERE "+ column+" LIKE \'"+data+"\'");
        ResultSet rs = ps.executeQuery();
        Societes societe = new Societes();
        while(rs.next()){
            societe.setIdSociete(rs.getString("idSociete"));
            societe.setName(rs.getString("Societe"));
            societe.setIdPays(rs.getInt("idPays"));
        }
        return societe;
    }

    public static void save(Societes newSocietes) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("INSERT INTO SOCIETES (Societe, idPays, idSociete) VALUES ("+
                "\'"+newSocietes.getName()+ "\',"+
                "\'"+newSocietes.getIdPays()+"\'," +
                "\'"+newSocietes.getIdSociete()+"\'" +
                ")");
        ps.executeUpdate();
    }

    public static void update(String previousId,Societes updatedSocietes) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection()
                .prepareStatement("UPDATE SOCIETES SET Societe="+"\'"+updatedSocietes.getName()+"\'"+"," +
                        " idPays="+"\'"+updatedSocietes.getIdPays()+"\'"+", " +
                        "idSociete="+"\'"+updatedSocietes.getIdSociete()+"\'"+
                        " WHERE idSociete Like "+"\'"+previousId+"\'");
        ps.executeUpdate();
    }

    public static void delete(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("DELETE FROM SOCIETES WHERE idSociete LIKE "+ "\'"+id+"\'");
    }

}
