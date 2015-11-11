<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajout de colis</title>
    </head>
    <body>
        <form method="post" action="add">
            <fieldset>
                <legend>Ajout de colis</legend>
                <p>Insérez les infomartions du colis</p>
                
                <label for="label">Label <span class="requis">*</span></label>
                <input type="text" id="label" name="label" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['label']}</span>

				<br><br>
                <label for="poids">Poids <span class="requis">*</span></label>
                <input type="number" id="poids" name="poids" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['poids']}</span>
                
                <br><br>
                <label for="valeur">Valeur <span class="requis">*</span></label>
                <input type="number" id="valeur" name="valeur" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['valeur']}</span>
                
                <br><br>
                <label for="origine">Origine <span class="requis">*</span></label>
                <input type="text" id="origine" name="origine" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['origine']}</span>
                
                <br><br>
                <label for="destination">Destination <span class="requis">*</span></label>
                <input type="text" id="destination" name="destination" value="" size="20" maxlength="20" />
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