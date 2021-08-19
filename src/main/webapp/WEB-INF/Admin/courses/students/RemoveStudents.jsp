<%@include file="../../../common/header.jspf"%>
<%@include file="../../../common/NavigationBar/AdminNavigation.jspf"%>

<style>
    .table-wrapper {
    max-height: 450px;
    overflow: scroll;
}

input[type=checkbox] {
    transform: scale(1.5);
}
</style>

<div class="container">

    <form method="POST" action="/Admin/RemoveStudents">
        <div class="table-wrapper">

            <table class = "table table-striped table-hover">
                <thead>
                <th>Student ID</th>
                <th>Student Name</th>
                <th>Student Email</th>
                <th>Student Grade</th>
                <th>Remove From Course</th>
                </thead>
                <tbody>
                <tr>
                    <c:forEach items="${list}" var="student">
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td class="grade">${student.grade}</td>
                        <td><input type="checkbox"  name="id" value="${student.id}"/> </td>
                </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <a class="btn btn-success" href="/Admin/courses">Cancel Removing</a>
        <input  class="btn btn-success" name="add" type="submit" />
</div>
</form>


</div>





<%@include file="../../../common/footer.jspf"%>
