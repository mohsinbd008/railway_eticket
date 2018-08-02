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
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 

    /* On small screens, set height to 'auto' for sidenav and grid */
  
  </style>
</head>
<body>
    <header class="container-fluid text-center" style="background-color: #2e6da4">
                        <img src="${pageContext.request.contextPath}/static/images/en-h-swiss-tavel-pass_0004_Layer-4(3).jpg"> 
</header>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
       
        <span class="icon-bar"></span>                        
      </button>
        <a class="navbar-brand" href="#" style="background-image: url(../images/train1.jpg)">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="http://localhost:8080/railway_eticket/#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="http://localhost:8080/railway_eticket/train/home">Train Info</a></li>
        <li><a href="http://localhost:8080/railway_eticket/coach/home">Coach Info</a></li>
        <li><a href="http://localhost:8080/railway_eticket/station/home">Station Info</a></li>
          <li><a href="http://localhost:8080/railway_eticket/route/home">Route Info</a></li>
        <li><a href="http://localhost:8080/railway_eticket/utype/home"> User Type</a></li>
        <li><a href="http://localhost:8080/railway_eticket/user/home">User Info</a></li>
        <li><a href="http://localhost:8080/railway_eticket/schedule/home">Schedule  Info</a></li>
        <li><a href="http://localhost:8080/railway_eticket/seatbooking/home">Seat Booking Info</a></li>
        <li><a href="http://localhost:8080/railway_eticket/booking/home">Booking Info</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
      <div class="col-sm-2 sidenav" style="background-color: darkgrey">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-sm-8 text-left"> 


    <head>
        <meta charset="UTF-8" /> 
        <title> Coach </title>
    </head>
    <body ng-app="myApp" style="background-color: darkseagreen">
    <center>
        <div ng-controller="CoachInfoConroller as objCtrl">
            <h1 style="color: green"> Coach Information </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New Coach </h3> 
                                <p style="color: red"> * marked fields are required to fill up.</p>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Coach for ID: {{ objCtrl.obj.coachId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Train Name</td>
                        <td>
                            <select ng-model="objCtrl.obj.trainInfo" ng-options="x.trainName for x in names">
                            </select><span  class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Coach Name: </td> <td><input type="text" name="coachName" ng-model="objCtrl.obj.coachName" required/> 
                            <span ng-show="objForm.coachName.$error.required" class="msg-val"> *</span> </td>
                    </tr>
                    <tr>
                        <td>Coach Type: </td> <td><input type="text" name="coachType" ng-model="objCtrl.obj.coachType" required/> 
                            <span ng-show="objForm.coachType.$error.required" class="msg-val">*</span> </td>
                    </tr>
                    <tr>
                        <td>Total Seat: </td> <td> <input type="text" name="totalSeat" ng-model="objCtrl.obj.totalSeat" required/> 
                            <span ng-show="objForm.totalSeat.$error.required" class="msg-val">*</span> </td>
                    </tr>
                    <tr>
                        <td>Ticket Price: </td> <td> <input type="text" name="ticketPrice" ng-model="objCtrl.obj.ticketPrice" required/> 
                            <span ng-show="objForm.ticketPrice.$error.required" class="msg-val">*</span> </td>
                    </tr>


                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Coach successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Coach already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Coach"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset" />
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" class="btn btn-success" ng-click="objCtrl.updateObjectDetail()" value="Update Coach"/> 	
                                <input type="button" class="btn btn-warning" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Coach successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> 
                    <th>Train Name</th> 
                    <th>Coach Name</th> 
                    <th>Coach Type</th>
                    <th>Total Seat</th>
                    <th>Ticket Price</th></tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.coachId"></span></td>
                    <td><span ng-bind="row.trainInfo.trainName"></span></td>
                    <td><span ng-bind="row.coachName"></span></td>
                    <td><span ng-bind="row.coachType"></span></td>
                    <td><span ng-bind="row.totalSeat"></span></td>
                    <td><span ng-bind="row.ticketPrice"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.coachId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.coachId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.coachId == objCtrl.updatedId" class="msg-success">Coach successfully updated.</span> </td> 
                </tr>	
<!--                <tr ng-repeat="row in objCtrl.objArray2">
                    <td><span ng-bind="row.tspName"></span></td>
                    
                </tr>-->
            </table>
        </div>
    </center>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/coach_info_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/app.css"/>  
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css"/>
        
    </body>

    </div>
  
  </div>
</div>

<footer class="container-fluid text-center">
  <p style="color: whitesmoke">@Powered by innovativeworld.com.bd</p>
</footer>

</body>
</html>


