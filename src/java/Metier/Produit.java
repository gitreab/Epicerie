/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;

import Connex.*;
import java.sql.*;


/**
 *
 * @author Faly Rajaonah
 */
public class Produit {
    int id_produit;
    String nom_produit;
    int id_type;
    int id_categorie;
    int prix;

    public Produit() {
    }

    public Produit(String nom_produit, int id_type, int id_categorie, int prix) {
        this.nom_produit = nom_produit;
        this.id_type = id_type;
        this.id_categorie = id_categorie;
        this.prix = prix;
    }

    public int getId_produit() {
        return id_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public int getId_type() {
        return id_type;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public int getPrix() {
        return prix;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    public void insertProduit( String nom_produit,int id_type,int id_categorie, int prix ) throws Exception{
        Connex con = new Connex();
        Connection c = con.connectPostgres();
        
        Statement stmt = c.createStatement();
        PreparedStatement pstmt = null;
        
        try{
            String query = "Insert Into Produit (nom_Produit,id_Type,id_Categorie,prix) values('"+nom_produit+"',"+id_type+","+id_categorie+","+prix+")";
            pstmt = c.prepareStatement(query);
            pstmt.executeUpdate();
            
        }catch(SQLException e){
         throw e;
        }finally {
            if (pstmt != null) {
                pstmt.close();
            }
            c.close();
        } 
    }
  
}
