<%@include file="../common/header.jspf"%>
<%@include file="../common/navigation.jspf"%>

<div class="container">


    Your New Students are
    <ol>
        <c:forEach items="${list}" var="student">
            <li>${student.fName}&nbsp;<a
                    href="/delete.do?todo=${student.fName}">Delete</a></li>
        </c:forEach>
    </ol>

    <p>
        <font color="red">${errorMessage}</font>
    </p>
    <form method="POST" action="/addStudent.do">



        <fieldset class="form-group">
            <label>Student First Name</label>
            <input name="fName" type="text" class="form-control"/> <BR/>

        </fieldset>

        <fieldset class="form-group">
            <label>Student Last Name</label>
            <input name="lName" type="text" class="form-control"/> <BR/>

        </fieldset>

        <fieldset class="form-group">
            <label>Student Email</label>
            <input name="email" type="text" class="form-control"/> <BR/>

        </fieldset>


        <a class="btn btn-success" href="/StudentServlet.do">Cancel Adding</a>
        <input  class="btn btn-success" name="add" type="submit" />


    </form>



</div>

<%@include file="../common/footer.jspf"%>
