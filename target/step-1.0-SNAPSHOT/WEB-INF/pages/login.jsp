<%@include file="../common/header.jspf"%>
<%@include file="../common/navigation.jspf"%>

<div class="container">

    <form action="/login.do" method="post">

        <p color="red">${errorM}</p>
        Email <input type="text" name="email"/>
        Password <input type="password" name="password"/>

        <input type="submit" value="login"/>

    </form>

</div>

<%@include file="../common/footer.jspf"%>

