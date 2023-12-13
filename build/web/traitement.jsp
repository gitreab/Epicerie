<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Metier.*" %>

<%
    String produit = request.getParameter("produit");
    String type = request.getParameter("type");
    String categorie = request.getParameter("categorie");
    String prix = request.getParameter("prix");
    
    int intType = Integer.parseInt(type);
    int intCategorie = Integer.parseInt(categorie);
    int intPrix = Integer.parseInt(prix);

    Produit p = new Produit();
    p.insertProduit(produit, intType, intCategorie, intPrix);
    
    // Set form data as attributes
    request.setAttribute("produit", produit);
    request.setAttribute("type", intType);
    request.setAttribute("categorie", intCategorie);
    request.setAttribute("prix", intPrix);
    
    // Redirect to ListeProduit.jsp
    response.sendRedirect("ListeProduits.jsp");
%>
