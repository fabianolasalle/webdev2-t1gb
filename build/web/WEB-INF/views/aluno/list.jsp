<div class="row">
    <div class="col">
        <table class="table table-striped table-sm">
            <thead>
              <tr>
                <th>#</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
            <c:foreach var="entry" items="${data}">
                <tr>
                    <td><c:out value=${entry}/></td>
                    
                    <td>

                    </td>
                </tr>
            </c:foreach>
            </tbody>
        </table>
    </div>
</div>