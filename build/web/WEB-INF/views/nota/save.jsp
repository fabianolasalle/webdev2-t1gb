<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"	%>
<div clas="row">
    <div class="col">
        <form method="POST" action="/webdev2-t1gb/nota/save">
           
            <div class="form-group">
                <label for="id_aluno">Aluno</label>
                <select class="form-control" name="id_aluno" name="id_aluno" required>
                    <c:forEach items="${alunos}" var="aluno">
                        <c:choose>
                            <c:when test="${data.id_aluno eq aluno.id}">
                                <option value="${aluno.id}" selected="true">${aluno.nome}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${aluno.id}">${aluno.nome}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="id_disciplina">Disciplina</label>
                <select class="form-control" name="id_disciplina" name="id_disciplina" required>
                    <c:forEach items="${disciplinas}" var="disciplina">
                        <c:choose>
                            <c:when test="${data.id_disciplina eq disciplina.id}">
                                <option value="${disciplina.id}" selected="true">${disciplina.nome}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${disciplina.id}">${disciplina.nome}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="nota1">Nota 1</label>
                <input type="text" class="form-control" name="nota1" id="nota1" placeholder="nota1" value="${data.nota1}" required>
            </div>

            <div class="form-group">
                <label for="nota2">Nota 2</label>
                <input type="text" class="form-control" name="nota2" id="nota2" placeholder="nota2" value="${data.nota2}" required>
            </div>

            <div class="form-group">
                <label for="nota3">Nota 3</label>
                <input type="text" class="form-control" name="nota3" id="nota3" placeholder="nota3" value="${data.nota3}" required>
            </div>
            
            <c:if test="${data.id gt 0}">
                <input type="hidden" name="id" value="${data.id}">
            </c:if>

            <button type="submit" class="btn btn-success">Salvar</button>
        </form>
    </div>
</div>