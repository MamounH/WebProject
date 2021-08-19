<%@include file="../common/header.jspf"%>
<%@include file="../common/NavigationBar/StuNav.jspf"%>



<div class="container">


    <table class = "table table-striped">
        <thead>
        <th>Course Name</th>
        <th>Course Instructor</th>
        <th>Grade</th>
        </thead>
        <tbody>
        <tr>
            <c:forEach items="${list}" var="course">
            <td>${course.courseName}</td>
            <td>${course.courseInstructor}</td>
            <td>${course.mark}</td>


        </tr>
        </c:forEach>

        </tbody>
    </table>

</div>





<%@include file="../common/footer.jspf"%>
