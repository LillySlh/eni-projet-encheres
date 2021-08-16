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
	<%@include file="../fragments/entete.jspf" %>
	<form action="" method="post">
		<div class="container">
			<label for="uname">Identifiant : </label>
			<input type="text" name="uname" required>
			<br>
			<label for="psw">Mot de passe : </label>
			<input type="password" name="psw" required>
			<br>
			<a href="servlet/#">
			<input type="submit" value="Connexion">
			</a>
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