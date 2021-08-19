<%@include file="../../common/header.jspf"%>
<%@include file="../../common/NavigationBar/AdminNavigation.jspf"%>



<div class="container">

     <table class = "table table-striped table-hover">
            <thead>
            <th>Course ID</th>
            <th>Course Name</th>
            <th>Instructor ID</th>
            <th>Instructor Name</th>
            </thead>
            <tbody>
            <tr>
                <c:forEach items="${list}" var="course">
                <td>${course.id}
                    <input type="hidden" name="id" value="${course.id}">
                </td>
                <td>${course.name}</td>
                <td>${course.instructorId}</td>
                <td>${course.instructorName}</td>
                <td><a class="btn btn-success" href="/Admin/AddStudent?id=${course.id}">Add Students</a></td>
                <td><a class="btn btn-warning" href="/Admin/RemoveStudents?id=${course.id}">Remove Students</a></td>
                <td><a class="btn btn-info" href="/Admin/UpdateCourse?id=${course.id}">Update Course</a></td>
                <td><a class="btn btn-danger" href="/Admin/DeleteCourse?id=${course.id}"
                           onclick="if (!(confirm('are you sure you want to delete this course'))) return false"
                    >Delete Course</a></td>
            </tr>
            </c:forEach>

            </tbody>
        </table>
    <a class="btn btn-success" href="/Admin/AddCourse">Add New Course</a>

</div>





<%@include file="../../common/footer.jspf"%>
