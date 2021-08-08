<%@include file="../common/header.jspf"%>
<%@include file="../common/navigation.jspf"%>



<div class="container">


    Your Courses;
    <form method="post" action="CourseMarks.do">
    <table class = "table table-striped">
        <thead>
        <th>Student ID</th>
        <th>Student Name</th>
        <th>Student Email</th>
        <th>Grade</th>
        <th>Update Grade</th>
        </thead>
        <tbody>
<%--        <tr>--%>
<%--            <c:forEach items="${list}" var="student">--%>
<%--            <td>${student.id}--%>
<%--            <input type="hidden" name="id" value="${student.id}">--%>
<%--            </td>--%>
<%--            <td>${student.name}</td>--%>
<%--            <td>${student.email}</td>--%>
<%--            <td>${student.grade}</td>--%>
<%--                <td>--%>
<%--                    <input type="text" name="mark"/>--%>
<%--                </td>--%>


<%--        </tr>--%>
<%--        </c:forEach>--%>

        </tbody>
    </table>

        <a class="btn btn-success" href="/InstructorServlet.do">Cancel</a>
        <input class="btn btn-success" type="submit" value="Update">
    </form>

</div>





<%@include file="../common/footer.jspf"%>
