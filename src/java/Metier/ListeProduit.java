/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metier;
import Connex.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Faly Rajaonah
 */
public class ListeProduit {
    String produit;
    String type;
    String categorie;
    int prix;

    public ListeProduit() {
    }

    public ListeProduit(String produit, String type, String categorie, int prix) {
        this.produit = produit;
        this.type = type;
        this.categorie = categorie;
        this.prix = prix;
    }

    public String getProduit() {
        return produit;
    }

    public String getType() {
        return type;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getPrix() {
        return prix;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    
    public ListeProduit[] getList() throws Exception{
        Connex con = new Connex();
        Connection c = con.connectPostgres();
        
        Statement stmt = c.createStatement();
        PreparedStatement pstmt = null;
        
        String query = "select * from ListeProduit";
        ResultSet render = stmt.executeQuery(query);
        
        Vector result = new Vector<ListeProduit>();
        while (render.next()){
            result.add(new ListeProduit(render.getString(1),render.getString(2),render.getString(3),render.getInt(4)));
        }
        ListeProduit[] valiny = new ListeProduit[result.size()];
        result.copyInto(valiny);
        stmt.close();
        c.close();
        return valiny;
    }
    
    public static void main(String[]args)throws Exception{
        
        ListeProduit l = new ListeProduit();
        ListeProduit[] tab = l.getList();
        for(int i = 0; i<tab.length; i++){
             System.out.println(tab[i].getProduit());
             System.out.println(tab[i].getType());
             System.out.println(tab[i].getCategorie());
             System.out.println(tab[i].getPrix());
        }
    }
    
}
