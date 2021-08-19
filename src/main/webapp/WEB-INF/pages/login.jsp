<%@include file="../common/css/login.css"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">




<div class="main">


    <div class="container">
        <div class="logo">Atypon University JenkinsTest
        </div>

        <center>
            <div class="middle">
                <div id="login">

                    <form action="/login" method="post">

                                <p color="red">${errorM}</p>

                        <fieldset class="clearfix">

                            <p ><span class="fa fa-user"></span><input type="text" name="email" Placeholder="Email" required></p>
                            <p><span class="fa fa-lock"></span><input type="password" name="password" Placeholder="Password" required></p>

                            <div>
                                <span style="width:50%; text-align:right;  display: inline-block;"><input type="submit" value="Sign In"></span>
                            </div>

                        </fieldset>
                        <div class="clearfix"></div>
                    </form>

                    <div class="clearfix"></div>

                </div>
                <div class="logo">
                    <img src="https://raw.githubusercontent.com/MamounH/Logo/main/AtyponLogo-RemovedBG.png" class="img img-responsive img-circle center-block"/>

                    <div class="clearfix"></div>
                </div>

            </div>
        </center>
    </div>

</div>




