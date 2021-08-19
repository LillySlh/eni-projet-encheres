<%--
  Created by IntelliJ IDEA.
  User: crach
  Date: 18/08/2021
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../../css/style.css">

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../fragments/entete.jspf" %>

<h2>Nouvelle Vente</h2>

<form action="" method="post" class="formContainer">
    <div class="formSubContainer">
        <div class="tr-form">
            <label for="article">Article :</label>
            <input type="text" name="article" id="article" required>
        </div>
        <div class="tr-form">
            <label for="description">Description :</label>
            <input type="text" name="description" id="description" required>
        </div>
        <div class="tr-form">
            <label for="categorie">Categorie :</label>
            <select id="categorie" name="categorie">
                <option value="1">1st choice</option>
                <option value="2">2nd choice</option>
                <option value="3">3rd choice</option>
            </select>
        </div>
        <div class="tr-form">
            <label for="photoArticle">Photo de l'article  :</label>
            <input type="text" name="photoArticle" id="photoArticle">
        </div>
        <div class="tr-form">
            <label for="miseAprix">Mise à prix :</label>
            <select id="miseAprix" name="miseAprix">
                <option value="1">100</option>
                <option value="2">200 choice</option>
                <option value="3">300 choice</option>
            </select>
        </div>

        <div class="tr-form">
            <label for="startAuction">Début de l'enchère :</label>
            <input type="date" name="startAuction" id="startAuction" required>
        </div>
        <div class="tr-form">
            <label for="endAuction">Fin de l'enchère :</label>
            <input type="date" name="endAuction" id="endAuction" required>
        </div>

            <div class="divRetrait">

                <div class="tr-form">
                    <label for="rue">Rue :</label>
                    <input type="text" name="rue" id="rue" >
                </div>

                <div class="tr-form">
                    <label for="cp">Code postal :</label>
                    <input type="text" name="cp" id="cp" >
                </div>

                <div class="tr-form">
                    <label for="ville">Ville :</label>
                    <input type="text" name="ville" id="ville" >
                </div>

            </div>
    </div>

    <div class="tr-button">
        <div class="profil-button">
            <a href="servlet/Home">
                <input type="submit" value="Créer">
            </a>
        </div>
        <div class="profil-button">
            <input type="button" value="Annuler" onclick="window.location.href = '${pageContext.request.contextPath}/../../../../eni_projet_encheres_war_exploded'">
        </div>
    </div>
</form>
</body>
</html>
