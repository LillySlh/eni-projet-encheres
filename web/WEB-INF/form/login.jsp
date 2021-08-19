<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../css/style.css">
<title>Connexion</title>
</head>
<body>
	<form action="" method="post">
		<div class="container">
			<label for="pseudo">Identifiant : </label>
			<input type="text" name="pseudo" id="pseudo"required>
			<br>
			<label for="mdp">Mot de passe : </label>
			<input type="password" name="motDePasse" id="mdp" required>
			<br>
			<input type="submit" value="Connexion">
			<label>
				<input type="checkbox" checked="checked" name="remember"> Se souvenir de moi
			</label>
			<a href="#">Mot de passe oublié</a>
		</div>

		<div class="container">
			<input type="button" value="Créer un compte" onclick="window.location.href = '${pageContext.request.contextPath}/servlet/ServletAddUser'">
		</div>
	</form>
</body>
</html>