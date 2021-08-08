<%@include file="../common/header.jspf"%>
<%@include file="../common/navigation.jspf"%>

<div class="container">

  <H1>Welcome ${name}</H1>

  Your New Todos are
  <ol>
    <c:forEach items="${todos}" var="todo">
      <li>${todo.name}&nbsp;<a
              href="/delete.do?todo=${todo.name}">Delete</a></li>
    </c:forEach>
  </ol>

  <p>
    <font color="red">${errorMessage}</font>
  </p>
  <form method="POST" action="/add.do">
    <fieldset class="form-group">
      <label>New Todo</label>
        <input name="todo" type="text" class="form-control"/> <BR/>

    </fieldset>

    <fieldset class="form-group">
      <label>New Category</label>

       <input name="category" type="text" class="form-control" /> <BR/>
    </fieldset>


    <input  class="btn btn-success" name="add" type="submit" />

  </form>

</div>

<%@include file="../common/footer.jspf"%>
