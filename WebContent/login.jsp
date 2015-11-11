<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
    </head>
    <body>
        <c:choose>
		    <c:when test="${!empty sessionScope.sessionClient}">
		        <p class="succes">Vous êtes déja connecter</p>
		    </c:when>    
		    <c:otherwise>
		        <form method="post" action="connexion">
		            <fieldset>
		                <legend>Connexion</legend>
		                
		                <label for="nom">Username <span class="requis">*</span></label>
		                <input type="text" id="username" name="username" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
		                
						<br><br>
		                <label for="motdepasse">Password <span class="requis">*</span></label>
		                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
		
						<br><br>
		                <input type="submit" value="Connexion" class="sansLabel" />
		            </fieldset>
		        </form>
		    </c:otherwise>
		</c:choose>
    </body>
</html>