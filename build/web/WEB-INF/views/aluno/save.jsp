<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"	%>
<div clas="row">
    <div class="col">
        <form method="POST" action="/webdev2-t1gb/aluno/save">
            <div class="form-group">
              <label for="nome">Nome</label>
              <input type="text" class="form-control" name="nome" id="nome" placeholder="nome" value="${data.nome}" maxlength="20" required>
            </div>

            <div class="form-group">
              <label for="endereco">Endereço</label>
              <input type="text" class="form-control" name="endereco" id="endereco" placeholder="endereco" value="${data.endereco}" required>
            </div>
            
            <div class="form-group">
              <label for="telefone">Telefone</label>
              <input type="text" class="form-control" name="telefone" id="telefone" placeholder="telefone" value="${data.telefone}" required>
            </div>

            <div class="form-group">
              <label for="email">E-mail</label>
              <input type="email" class="form-control" name="email" id="email" placeholder="email" value="${data.email}" required>
            </div>

            <div class="form-group">
              <label for="matricula">Matrícula</label>
              <input type="text" class="form-control" name="matricula" id="matricula" placeholder="matricula" value="${data.matricula}" required>
            </div>

            <div class="form-group">
              <label for="cpf">CPF</label>
              <input type="text" class="form-control" name="cpf" id="cpf" placeholder="cpf" value="${data.cpf}" required>
            </div>            
            
            <c:if test="${data.id gt 0}">
                <input type="hidden" name="id" value="${data.id}">
            </c:if>
            
            <button type="submit" class="btn btn-success">Salvar</button>
        </form>
    </div>
</div>