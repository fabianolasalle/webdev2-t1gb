<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"	%>
<div clas="row">
    <div class="col">
        <form method="POST" action="/webdev2-t1gb/disciplina/save">
            <div class="form-group">
                <label for="nome">Nome</label>
                <input type="text" class="form-control" name="nome" id="nome" placeholder="nome" value="${data.nome}" maxlength="20" required>
            </div>

            <div class="form-group">
                <label for="codigo">Código</label>
                <input type="text" class="form-control" name="codigo" id="codigo" placeholder="codigo" value="${data.codigo}" maxlength="10" required>
            </div>

            <div class="form-group">
                <label for="cargaHoraria">Carga Horária</label>
                <input type="text" class="form-control" name="cargaHoraria" id="cargaHoraria" placeholder="carga horária" value="${data.cargaHoraria}" required>
            </div>

            <div class="form-group">
                <label for="id_professor">Professor</label>
                <select class="form-control" name="id_professor" name="id_professor" required>
                    <c:forEach items="${professores}" var="professor">
                        <c:choose>
                            <c:when test="${data.id_professor eq professor.id}">
                                <option value="${professor.id}" selected="true">${professor.nome}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${professor.id}">${professor.nome}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>

            <c:if test="${data.id gt 0}">
                <input type="hidden" name="id" value="${data.id}">
            </c:if>

            <button type="submit" class="btn btn-success">Salvar</button>
        </form>
    </div>
</div>