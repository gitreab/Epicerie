/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Affichage;
import Connex.*;
import Metier.*;

/**
 *
 * @author Faly Rajaonah
 */
public class Affichage {
    
    public static void main(String[]args)throws Exception{
        Connex con = new Connex();
        con.testConnection();
        
        // Insert Produit
        String nom = ("Voanjo");
        int type = Integer.parseInt(("2"));
        int categorie = Integer.parseInt(("3"));
        int prix = Integer.parseInt(("2000"));
        
        Produit p = new Produit();
        p.insertProduit(nom, type, categorie, prix);
        
        
        
        // ListeProduit    
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
