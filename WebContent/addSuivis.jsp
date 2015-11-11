<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajout de coordonnées</title>
    </head>
    <body>
        <form method="post" action="addSuivis">
            <fieldset>
                <legend>Ajout de coordonnées</legend>
                
                <p>Selectionnez un colis</p>
                
                <select name="colis">
				   <c:forEach items="${sessionScope.sessionColis}" var="item">
				       <option value="${item.id}">${item.label}</option>
				   </c:forEach>
				</select>
                	
                <p>Insérez les nouvelles coordonnées du colis</p>

                <label for="latitude">Latitude <span class="requis">*</span></label>
                <input type="number" id="latitude" name="latitude"  size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['poids']}</span>
                
                <br><br>
                <label for="longitude">Longitude <span class="requis">*</span></label>
                <input type="number" id="longitude" name="longitude" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['valeur']}</span>
                
                <br><br>
                <label for="emplacement">Emplacement <span class="requis">*</span></label>
                <input type="text" id="emplacement" name="emplacement" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['origine']}</span>
                
                <br><br>
                <label for="etat">Etat <span class="requis">*</span></label>
                <input type="text" id="etat" name="etat" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['destination']}</span>

				<br><br>
                <input type="submit" value="Ajouter" class="sansLabel" />
                
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
                <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.sessionClient}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <p class="succes">Vous êtes connecté(e) avec : ${sessionScope.sessionClient.username}</p>
                </c:if>
            </fieldset>
        </form>
    </body>
</html>