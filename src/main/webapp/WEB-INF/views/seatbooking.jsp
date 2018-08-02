<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Seat Booking </title>
    </head>
    <body ng-app="myApp" style="background-color: appworkspace">
          <header class="container-fluid text-center"style="background-image: url(images/innovative-banner1.jpg)" >
    <h1>Innovative World of Technology</h1>
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
    <center>
        <div ng-controller="SeatBookingController as objCtrl">
            <h1 style="color: green">Seat Booking Information </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h2> Add Seat Booking </h2> 
                                <p style="color: red"> * marked fields are required to fill up.</p>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Seat Booking for ID: {{ objCtrl.obj.boSeatId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Coach Name</td>
                        <td>
                            <select ng-model="objCtrl.obj.coachInfo" ng-options="x.coachName for x in names">
                            </select><span  class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Booking ID</td>
                        <td>
                            <select ng-model="objCtrl.obj.booking" ng-options="y.bookId for y in nams">
                            </select><span  class="msg-val">*</span>
                        </td>
                    </tr>
                     <tr>
                        <td> Seat No: </td> <td> <input type="text" name="seatNo" ng-model="objCtrl.obj.seatNo" required/> 
                            <span ng-show="objForm.seatNo.$error.required" class="msg-val">*</span> </td>
                    </tr>
               
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Seat Booking successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Seat Booking already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add New Seat Booking"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Seat Booking"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Seat Booking successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> 
                    <th>Coach Name</th>
                    <th>Booking ID</th> 
                    <th>Seat No</th> 
            
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.boSeatId"></span></td>
                    <td><span ng-bind="row.coachInfo.coachName"></span></td>
                    <td><span ng-bind="row.booking.bookId"></span></td>
                    <td><span ng-bind="row.seatNo"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.boSeatId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.boSeatId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.boSeatId == objCtrl.updatedId" class="msg-success">Booking successfully updated.</span> </td> 
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
        <script src="${pageContext.request.contextPath}/static/js/controller/booking_seat_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/app.css"/>  
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css"/>
    </body>
</html> 