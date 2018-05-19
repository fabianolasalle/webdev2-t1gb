<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"	%>
<div clas="row">
    <div class="col">
        <div class="card">
            <div class="card-header">
                Pesquisa de nota
            </div>
            <div class="card-body">
                <form method="POST" action="/webdev2-t1gb/consulta">

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

                    <button type="submit" class="btn btn-success">Salvar</button>
                </form>  
            </div>
        </div>
    </div>
</div>

<c:if test="${not empty data.getMedia()}">
    <div class="row mt-3">
        <div class="col">
            <div class="card ${data.getStatusCor()}">
                <div class="card-body text-center">
                    ${data.getStatus()}. Nota: ${data.getMedia()}
                </div>
            </div>
        </div>
    </div>
</c:if>