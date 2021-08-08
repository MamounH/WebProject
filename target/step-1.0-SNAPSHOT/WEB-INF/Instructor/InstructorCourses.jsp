<%@include file="../common/header.jspf"%>
<%@include file="../common/navigation.jspf"%>



<div class="container">


    Your Courses;

    <table class = "table table-striped">
        <thead>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Manage Enrolled Students</th>
        </thead>
        <tbody>
        <tr>
            <c:forEach items="${list}" var="course">
            <td>${course.id}</td>
            <td>${course.name}</td>
            <td><a class="btn btn-info" href="/CourseMarks.do?courseId=${course.id}">Enrolled Students</a></td>

        </tr>
        </c:forEach>

        </tbody>
    </table>

</div>





<%@include file="../common/footer.jspf"%>
