<%@include file="../../common/header.jspf"%>
<%@include file="../../common/NavigationBar/AdminNavigation.jspf"%>

<div class="container">


  Update User

  <form method="POST" action="/Admin/UpdateCourse.do">

    <input type="hidden" name="id" value="${course.id}"/>

    <fieldset class="form-group">
      <label>Course Name</label>
      <input name="name" type="text" class="form-control" value="${course.name}" required/> <BR/>

    </fieldset>

    <fieldset class="form-group">
      <label>Instructor Id</label>
      <input name="Instructor_id" type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');"
             class="form-control" value="${course.instructorId}" required/> <BR/>

    </fieldset>


    <a class="btn btn-success" href="/Admin/courses.do">Cancel Updating</a>
    <input  class="btn btn-success" name="add" type="submit" />


  </form>



</div>

<%@include file="../../common/footer.jspf"%>
