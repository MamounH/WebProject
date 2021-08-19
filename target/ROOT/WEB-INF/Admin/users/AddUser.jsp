<%@include file="../../common/header.jspf"%>
<%@include file="../../common/NavigationBar/AdminNavigation.jspf"%>

<div class="container">


  <p>
    <font color="red">${errorMessage}</font>
  </p>
  <form method="POST" action="/Admin/AddUser.do">



    <fieldset class="form-group">
      <label>User First Name</label>
      <input name="fName" type="text" class="form-control" required/> <BR/>

    </fieldset>

    <fieldset class="form-group">
      <label>User Last Name</label>
      <input name="lName" type="text" class="form-control" required/> <BR/>

    </fieldset>

    <fieldset class="form-group">
      <label>User Email</label>
      <input name="email" type="text" class="form-control" required/> <BR/>

    </fieldset>

    <fieldset class="form-group">
      <label>User Password</label>
      <input name="password" type="password" class="form-control" minlength="8" max="12" required/> <BR/>

    </fieldset>

    <fieldset class="form-group">
      <label>User Role</label>
      <INPUT TYPE="radio" name="role" value="ADMIN"/> Admin
      <INPUT TYPE="radio" NAME="role" VALUE="INSTRUCTOR"/> Instructor
      <INPUT TYPE="radio" NAME="role" VALUE="STUDENT"/> Student
    </fieldset>

    <a class="btn btn-success" href="/Admin/Users.do">Cancel Adding</a>
    <input  class="btn btn-success" name="add" type="submit" />


  </form>



</div>

<%@include file="../../common/footer.jspf"%>
