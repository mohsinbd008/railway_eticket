<%-- 
    Document   : template_page
    Created on : Apr 23, 2018, 12:42:50 PM
    Author     : Mohsin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <style>
            /* Remove the navbar's default margin-bottom and rounded borders */
            .carousel-inner img {
                width: 900px;
                height: 450px;
            }
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
                padding: 10px;
            }

            /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
            .row.content {height: 450px}

            /* Set gray background color and 100% height */
            .sidenav {
                padding-top: 20px;
                background-color: #f1f1f1;
                height: 100%;
            }

            /* Set black background color, white text and some padding */
            footer {
                background-color: #555;
                color: white;
                padding: 15px;
            }
            header {
                background-color: #5cb85c;
                color: white;
                padding: 25px;
                height:100px;
            }


            /* On small screens, set height to 'auto' for sidenav and grid */
            @media screen and (max-width: 767px) {
                .sidenav {
                    height: auto;
                    padding: 15px;
                }
                .row.content {height:auto;} 
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="header">
                
                <header class="container-fluid text-center" >
                    <h1>Bangladesh Railway E-Ticketing Service</h1>


                </header>
            </div>
        
  <div class="container-fluid">
            <div class="menu">
                <nav class="navbar navbar-expand-sm bg-light">

                    <!-- Links -->
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contact</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Login</a>
                        </li>
                    </ul>
                    <form class="form-inline" action="/action_page.php">
                        <input class="form-control mr-sm-2" type="text" placeholder="Search">
                        <button class="btn btn-success" type="submit">Search</button>
                    </form>

                </nav>
            </div>
  </div>
          
            
                <div class="row content">
                <div id="demo" class="carousel slide col-sm-7" data-ride="carousel">

                    <!-- Indicators -->
                    <ul class="carousel-indicators">
                        <li data-target="#demo" data-slide-to="0" class="active"></li>
                        <li data-target="#demo" data-slide-to="1"></li>
                        <li data-target="#demo" data-slide-to="2"></li>
                    </ul>

                    <!-- The slideshow -->
                    <div class="carousel-inner">
                        <div class="carousel-item ">
                            <img src="${pageContext.request.contextPath}/static/images/cologne-central-station-railway-station-train-163580.jpeg" alt="Los Angeles" width="200" height="200">

                        </div>
                        <div class="carousel-item">
                            <img src="${pageContext.request.contextPath}/static/images/unnamed.png" alt="Chicago" width="400" height="400">
                        </div>
                        <div class="carousel-item">
                            <img src="${pageContext.request.contextPath}/static/images/images.jpg" alt="Chicago" width="400" height="400">
                        </div>
                        <div class="carousel-item">
                            <img src="${pageContext.request.contextPath}/static/images/pexels-photo-321569.jpeg" alt="Chicago" width="400" height="400">
                        </div>
                        <div class="carousel-item active">
                            <img src="${pageContext.request.contextPath}/static/images/938219230-1024x1024.jpg" alt="New york" width="400" height="400">
                        </div>
                    </div>

                    <!-- Left and right controls -->
                    <a class="carousel-control-prev" href="#demo" data-slide="prev">
                        <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#demo" data-slide="next">
                        <span class="carousel-control-next-icon"></span>
                    </a>
                </div>
                    
                        <div class="col-sm-5">
                            <h2 style="color: darkcyan">Welcome!!</h2>
                            Purchasing tickets through Internet is another convenient way to travel with Bangladesh Railway. Register yourself with your cell phone number, book online and your ticket details will then be emailed to you instantly after payment through your any VISA/MASTER, DBBL Nexus/VISA/MASTER/Mobile Banking and City bank Amex cards. Print it out and bring it along with your valid Identity card to the station at least 15 minutes prior to your journey. If you purchase e-ticket for other persons, you have to print out hard copy of e-ticket from designated counters of any online stations.If you are not yet registered please <a href="register/home">register </a> here for futher procedure.
                        </div>       
           </div>
                     
            <div class="footer">
                <footer class="container-fluid text-center">
                    <p style="color: whitesmoke">@Powered by innovativeworld.com.bd</p>
                </footer>
            </div>
   </div>
    </body>
</html>


