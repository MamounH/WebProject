<%@include file="../common/header.jspf"%>
<%@include file="../common/navigation.jspf"%>

<div class="container">


    Update Student

    <p>
        <font color="red">${errorMessage}</font>
    </p>

    <form method="POST" action="/addStudent.do">

        <input type="hidden" name="id" value="${student.id}"/>

        <fieldset class="form-group">
            <label>Student First Name</label>
            <input name="fName" type="text" class="form-control" value="${student.fName}"/> <BR/>

        </fieldset>

        <fieldset class="form-group">
            <label>Student Last Name</label>
            <input name="lName" type="text" class="form-control" value="${student.lName}"/> <BR/>

        </fieldset>

        <fieldset class="form-group">
            <label>Student Email</label>
            <input name="email" type="text" class="form-control" value="${student.email}"/> <BR/>

        </fieldset>


        <a class="btn btn-success" href="/StudentServlet.do">Cancel Adding</a>
        <input  class="btn btn-success" name="add" type="submit" />


    </form>



</div>

<%@include file="../common/footer.jspf"%>
