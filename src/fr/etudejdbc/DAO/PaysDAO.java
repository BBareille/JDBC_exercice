package fr.etudejdbc.DAO;

import fr.etudejdbc.model.Pays;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static fr.etudejdbc.App.databaseConnection;

public class PaysDAO {

    public static Pays find(Integer id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("SELECT * FROM PAYS WHERE idPays="+id);
        ResultSet rs = ps.executeQuery();
        Pays pays = new Pays();
        while(rs.next()){
            pays.setId(rs.getInt("idPays"));
            pays.setName(rs.getString("Pays"));
        }
        return pays;
    }

    public static Pays findWhere(String column, String data) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("SELECT * FROM PAYS WHERE " + column+"= \'"+data+"\'");
        ResultSet rs = ps.executeQuery();
        Pays pays = new Pays();
        while(rs.next()){
            pays.setId(rs.getInt("idPays"));
            pays.setName(rs.getString("Pays"));
        }
        return pays;
    }

    public static void save(Pays newPays) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("INSERT INTO Pays (Pays) VALUES ("+
                "\'"+newPays.getName()+"\'"+
                ")");
        ps.executeUpdate();
    }

    public static void delete(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = databaseConnection().prepareStatement("DELETE FROM PAYS WHERE idPays="+id);
    }
}
