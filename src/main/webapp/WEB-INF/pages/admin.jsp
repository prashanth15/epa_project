<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <!--<title>Heroic Features - Start Bootstrap Template</title>-->
    <title>Project EPA</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="assets/css/main.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->
</head>
<body>

  <div class="wrapper">
    <header>
        <div class="user-bar">
           <div class="padding-gen">
              <div class="logo">
                  <img src="assets/images/img-logo.png" alt="">
              </div>

              <div class="pull-right">
                  <div class="panel-user">
                      <div class="user-icon"><img src="assets/images/user-icon.png" alt="user-icon"></div>
                      <div class="user-name">P. Prashanth</div>
                      <div class="user-role">
                        <a href="individual.jsp">Individual</a>
                      </div>
                      <div class="logout"><button class="button-txt">Logout</button></div>
                  </div>
              </div>
            </div>
        </div>
    </header>

    <div class="panel-title">
      <div class="padding-gen">Dashboard - Admin</div>
    </div>

    <div class="content">
      <div class="padding-gen">
        <div class="row">
          <div class="w50">
              <div class="sub-title"> Top 5 Employees </div>
              <div id="columnchart_values-1"></div>
          </div>
          <div class="w50">
              <div class="sub-title"> Top 5 Projects </div>
              <div id="columnchart_values-2"></div>
          </div>
        </div>
      </div>
    </div>

    <footer>
      @Copyright 2017. Prashanth Prabaharan.
    </footer>
  </div>

  <!-- scripts -->
  <script type="text/javascript" src="assets/js/jquery-1.12.3.min.js"></script>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript" src="assets/js/main.js"></script>

</body>
</html>
