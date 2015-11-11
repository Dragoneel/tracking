<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Détails du suivi</title>
</head>
<body>
		<h2>Détails du suivi</h2>
        <c:choose>
		    <c:when test="${empty sessionScope.sessionClient}">
		        <p class="warning">Connectez-vous via le lien suivant</p>
		        <a href="/tp1_info921/connexion">Connexion</a>
		    </c:when>    
		    <c:otherwise>
		        <p class="succes">Nom et prénom : ${sessionScope.sessionClient.nom}</p>
                <p class="succes">Adresse de livraison : ${sessionScope.sessionClient.adresse}</p>
                <c:forEach items="${sessionScope.sessionSuivi}" var="suivi"> 
				  <ul>
				    <li>${suivi.latitude}</li>
                	<li>${suivi.longitude}</li>
                	<li>${suivi.emplacement}</li>
                	<li>${suivi.etat}</li>
                  </ul>
                  <br/><br/>
				</c:forEach>
                
		    </c:otherwise>
		</c:choose>
</body>
</html>