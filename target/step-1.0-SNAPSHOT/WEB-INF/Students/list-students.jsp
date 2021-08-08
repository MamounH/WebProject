<%@include file="../common/header.jspf"%>
<%@include file="../common/navigation.jspf"%>



<div class="container">

    <H1>Welcome ${name}</H1>

    Your Students are

<%--    <table class = "table table-striped">--%>
        <table class = "table table-hover">

        <thead>
        <th>ID</th>
        <th>Name</th>
        <th>MidName</th>
        <th>Email</th>
        </thead>
        <tbody>
        <tr>
            <c:forEach items="${list}" var="student">
            <td>${student.id}</td>
            <td>${student.fName}</td>
            <td>${student.lName}</td>
            <td>${student.email}</td>
            <td><a class="btn btn-info" href="/UpdateStudent.do?id=${student.id}">Update</a></td>
            <td><a class="btn btn-danger" href="/deleteStudent.do?id=${student.id}"
            onclick="if (!(confirm('are you sure you want to delete this student'))) return false"
            >Delete</a></td>

        </tr>
        </c:forEach>

        </tbody>
    </table>

    <p>
        <font color="red">${errorMessage}</font>
    </p>
    <a class="btn btn-success" href="/addStudent.do">Add</a>
</div>





<%@include file="../common/footer.jspf"%>
