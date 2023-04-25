package fr.etudejdbc;

import com.mysql.cj.jdbc.Driver;
import fr.etudejdbc.DAO.*;
import fr.etudejdbc.model.*;

import java.sql.*;


public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //First task
        System.out.println(EmployesDAO.findAll());

//        //Second task
        Pays pays = new Pays();
        pays.setName("Danemark");
        PaysDAO.save(pays);
//
//
        Societes societes = new Societes();
        societes.setName("Coca-Cola");
        societes.setIdSociete("saucisse4"); //Dans le cas d'une base de données NORMALISER, nous n'avons pas à renseigner ce champs.
        societes.setIdPays(PaysDAO.findWhere("Pays","Etats-Unis").getId());
        SocietesDAO.save(societes);

        Employes employes1 = new Employes();
        employes1.setNom("Du Bateau");
        employes1.setPrenom("Edouard");
        employes1.setIdPays(PaysDAO.findWhere("Pays","Etats-Unis").getId());
        employes1.setIdSociete(societes.getIdSociete());
        employes1.setSalaireMensuel(1500.0f);
        employes1.setIdResponsable(3);
        EmployesDAO.save(employes1);
//
//        //Third task
        Employes employeToModify = EmployesDAO.find(1);
        employeToModify.setNom("Paul");
        EmployesDAO.update(1,employeToModify);

        //Fourth task
        EmployesDAO.delete(1);

        //Fifth & Sixth task
        EmployesDAO.change_salary_and_responsable(15000.0f, 2, 1);
    }

    public static Connection databaseConnection() throws SQLException, ClassNotFoundException {
        Class<?> driver = Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlConnection = "jdbc:mysql://root:@localhost:3306/mabase?noAccessToProcedureBodies=true&useSSL=false";
        Connection connection = DriverManager.getConnection(sqlConnection);
        return connection;
    }




}
