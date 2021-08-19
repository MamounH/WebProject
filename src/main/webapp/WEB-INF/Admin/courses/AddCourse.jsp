<%@include file="../../common/header.jspf"%>
<%@include file="../../common/NavigationBar/AdminNavigation.jspf"%>

<div class="container">


    <p>
        <font color="red">${errorMessage}</font>
    </p>
    <form method="POST" action="/Admin/AddCourse">



        <fieldset class="form-group">
            <label>Course Name</label>
            <input name="name" type="text" class="form-control" required/> <BR/>

        </fieldset>

        <fieldset class="form-group">

            <label>Select Course Instructor</label>
            <select name="instructorID">
            <c:forEach items="${list}" var="instructor">
            <option value="${instructor.id}"> ${instructor.fName} ${instructor.lName} </option>
            </c:forEach>
            </select>

        </fieldset>


        <a class="btn btn-success" href="/Admin/courses">Cancel Adding</a>
        <input  class="btn btn-success" name="add" type="submit" />


    </form>



</div>

<%@include file="../../common/footer.jspf"%>
