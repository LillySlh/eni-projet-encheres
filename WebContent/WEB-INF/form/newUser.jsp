<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../css/style.css">
<title>Nouveau profil</title>
</head>
<body>
	<%@include file="../fragments/entete.jspf" %>
	<h2>Mon profil</h2>
	<form action="" method="post" class="inscription">
		<div class="inscription1">
			<div class="tr-form">
				<label for="pseudo">Pseudo :</label>
				<input type="text" name="pseudo" class="input-form" required>
			</div>
			<div class="tr-form">
				<label for="prenom">Prénom :</label>
				<input type="text" name="prenom" class="input-form" required>
			</div>
			<div class="tr-form">
				<label for="tel">Téléphone :</label>
				<input type="text" name="telephone" class="input-form" required>
			</div>
			<div class="tr-form">
				<label for="cp">Code postal :</label>
				<input type="text" name="code postal" class="input-form" required>
			</div>
			<div class="tr-form">
				<label for="mdp">Mot de passe :</label>
				<input type="text" name="mot de passe" class="input-form" required>
			</div>
		</div>
		<div class="inscription2">
			<div class="tr-form">
				<label for="nom">Nom :</label>
				<input type="text" name="nom" id="nom" required>
			</div>
			<div class="tr-form">
				<label for="email">Email :</label>
				<input type="text" name="email" id="email" required>
			</div>
			<div class="tr-form">
				<label for="rue">Rue :</label>
				<input type="text" name="rue" id="rue" required>
			</div>
			<div class="tr-form">
				<label for="ville">Ville :</label>
				<input type="text" name="ville" id="ville" required>
			</div>
			<div class="tr-form">
				<label for="confirmation">Confirmation :</label>
				<input type="text" name="confirmation" id="confirmation" required>
			</div>
		</div>
	</form>
	<div class="tr-button">
  		<div class="profil-button">
    		<input type="submit" value="Créer" href="servlet/listeencheres">
 		</div>
 		<div class="profil-button">
    		<input type="button" value="Annuler" onclick="window.location.href = '${pageContext.request.contextPath}/../../eni-projet-encheres'">
 		</div>
 	</div>
</body>
</html>