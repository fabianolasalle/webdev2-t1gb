<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"	%>
<div class="row mb-3">
    <div class="col">
        <a href="/webdev2-t1gb/professor/save" class="btn btn-success"><i class="fas fa-plus-square"></i> Adicionar</a>
    </div>
</div>
<div class="row">
    <div class="col">
        <table class="table table-striped table-sm">
            <thead>
              <tr>
                <th>#</th>
                <th>Nome</th>
                <th>Registro</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="entry" items="${data}">
                <tr>
                    <td>${entry.id}</td>
                    <td>${entry.nome}</td>
                    <td>${entry.registro}</td>

                    <td>
                        <a href="/webdev2-t1gb/professor/save/${entry.id}"><button class="btn btn-sm btn-primary"><i class="fas fa-edit"></i></button></a>
                        <a href="/webdev2-t1gb/professor/remove/${entry.id}"><button class="btn btn-sm btn-danger"><i class="fas fa-times"></i></button></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>