<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Accueil</title>
</head>
<body>
	<nav>
		<a href="${pageContext.request.contextPath}/servlet/Login">S'inscrire - Se connecter</a>
	</nav>
<%@include file="WEB-INF/fragments/entete.jspf" %>
	
	<h2>Liste des enchères</h2>
	<form>
		<div class="search">
			<label for="search" class="lb-search">Filtres :</label>
			<div class="search-bar">
			<input type="search" value="  Le nom de l'article contient" id="search">
			</div>
		</div>
		<div class="bt-search">
			<input type="submit" value="Rechercher">
		</div>
		<div class="categorie">
			<label for="categorie-select">Catégorie :</label>
			<select name="categorie" id="categorie-select">
				<option value="toutes">Toutes</option>
				<option value="informatique">Informatique</option>
				<option value="ameublement">Ameublement</option>
				<option value="vetelents">Vêtements</option>
				<option value="sports&loisir">Sports & Loisirs</option>
			</select>
		</div>
	</form>
</body>
</html>