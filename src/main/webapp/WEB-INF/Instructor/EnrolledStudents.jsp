<%@include file="../common/header.jspf"%>
<%@include file="../common/NavigationBar/InstNav.jspf"%>


<div class="container">


    <form method="post" action="/Instructor/CourseMarks">
    <table class = "table table-striped">
        <thead>
        <th>Student ID</th>
        <th>Student Name</th>
        <th>Student Email</th>
        <th>Grade</th>
        <th>Update Grade</th>
        </thead>
        <tbody>
        <tr>
            <c:forEach items="${list}" var="student">
            <td>${student.id}
            <input type="hidden" name="id" value="${student.id}">
            </td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.grade}</td>
                <td>
                    <input type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');"
                           name="mark"/>
                </td>


        </tr>
        </c:forEach>

        </tbody>
    </table>

        <a class="btn btn-success" href="/Instructor/Courses">Cancel</a>
        <input class="btn btn-success" type="submit" value="Update">
    </form>

</div>





<%@include file="../common/footer.jspf"%>
