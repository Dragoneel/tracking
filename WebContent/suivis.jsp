<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suivis de colis</title>
</head>
<body>
		<h2>Suivis des colis</h2>
        <c:choose>
		    <c:when test="${empty sessionScope.sessionClient}">
		        <p class="warning">Connectez-vous via le lien suivant</p>
		        <button>Connexion</button>
		    </c:when>    
		    <c:otherwise>
		        <p class="succes">Nom et prénom : ${sessionScope.sessionClient.nom}</p>
                <p class="succes">Adresse de livraison : ${sessionScope.sessionClient.adresse}</p>
                <c:forEach items="${sessionScope.sessionColis}" var="colis"> 
				  <ul>
                	<li>${colis.label}</li>
                	<li>${colis.poids}</li>
                	<li>${colis.valeur}</li>
                	<li>${colis.origine}</li>
                	<li>${colis.destination}</li>
                  </ul>
                  <a href="/tp1_info921/showSuivis?id=${colis.id}")>Afficher le suivi</a>
                  <br/><br/>
				</c:forEach>
                
		    </c:otherwise>
		</c:choose>
</body>
</html>