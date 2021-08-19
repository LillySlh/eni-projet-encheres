<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>Accueil</title>
</head>
<body>
	<%@include file="fragments/entete.jspf" %>
	<h2>Liste des enchères</h2>
	<form class="container-encheres">
		<div class="search">
			<label for="search" class="lb-search">Filtres :</label>
			<div class="search-bar">
				<input type="search" value="  Le nom de l'article contient" id="search">
			</div>
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
			<div class="bt-search">
				<input type="submit" value="Rechercher"  id="input-search">
			</div>
			<div class="radio-bt">
				<div>
					<input type="radio" id="achats" name="btn_radio-index" value="achats">
					<label for="achats" class="lb-radio">Achats</label>
					<div>
						<input type="checkbox" id="encheres-ouvertes" name="encheres-ouvertes">
						<label for="encheres-ouvertes">enchères ouvertes</label>
					</div>

					<div>
						<input type="checkbox" id="encheres-en-cours" name="encheres-en-cours">
						<label for="encheres-en-cours">mes enchères en cours</label>
					</div>
					<div>
						<input type="checkbox" id="encheres-remportees" name="encheres-remportees">
						<label for="encheres-remportees">mes enchères remportées</label>
					</div>
				</div>
				<div>
					<input type="radio" id="ventes" name="btn_radio-index" value="ventes">
					<label for="ventes" class="lb-radio">Mes ventes</label>
					<div>
						<input type="checkbox" id="ventes-en-cours" name="ventes-en-cours">
						<label for="ventes-en-cours">mes ventes en cours</label>
					</div>

					<div>
						<input type="checkbox" id="ventes-non-débutees" name="ventes-non-débutees">
						<label for="ventes-non-débutees">ventes non débutées</label>
					</div>
					<div>
						<input type="checkbox" id="ventes-terminees" name="ventes-terminees">
						<label for="ventes-terminees">ventes terminées</label>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>