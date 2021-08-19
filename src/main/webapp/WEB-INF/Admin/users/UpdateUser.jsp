<%@include file="../../common/header.jspf"%>
<%@include file="../../common/NavigationBar/AdminNavigation.jspf"%>

<div class="container">

    <form method="POST" action="/Admin/UpdateUser">

        <input type="hidden" name="id" value="${user.id}"/>

        <fieldset class="form-group">
            <label>User First Name</label>
            <input name="fName" type="text" class="form-control" value="${user.fName}" required/> <BR/>

        </fieldset>

        <fieldset class="form-group">
            <label>User Last Name</label>
            <input name="lName" type="text" class="form-control" value="${user.lName}" required/> <BR/>

        </fieldset>

        <fieldset class="form-group">
            <label>User Email</label>
            <input name="email" type="text" class="form-control" value="${user.email}" required/> <BR/>

        </fieldset>


        <a class="btn btn-success" href="/Admin/Users">Cancel Updating</a>
        <input  class="btn btn-success" name="add" type="submit" />


    </form>



</div>

<%@include file="../../common/footer.jspf"%>
