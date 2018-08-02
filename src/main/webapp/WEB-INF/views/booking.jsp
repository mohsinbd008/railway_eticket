<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Booking </title>
    </head>
    <body ng-app="myApp" style="background-color: #66afe9">
          <header class="container-fluid text-center"style="background-image: url(images/innovative-banner1.jpg)" >
                 <img src="${pageContext.request.contextPath}/static/images/India-rail-solar-panels-banner-1580x530(1).jpg"> 
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
        <div ng-controller="BookingController as objCtrl">
            <h1> Booking Information </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add Booking </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Booking for ID: {{ objCtrl.obj.bookId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>User</td>
                        <td>
                            <select ng-model="objCtrl.obj.user" ng-options="x.userName for x in names">
                            </select><span  class="msg-val">*</span>
                        </td>
                    </tr>
                      <tr>
                        <td>Ticket Price</td>
                        <td>
                            <select ng-model="objCtrl.obj.coachInfo" ng-options="x.ticketPrice for x in namss">
                            </select><span  class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Train Schedule</td>
                        <td>
                            <select ng-model="objCtrl.obj.trainSchedule" ng-options="y.deparDate for y in nams">
                            </select><span  class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Book Date: </td> <td><input type="date" name="bookDate" ng-model="objCtrl.obj.bookDate" required/> 
                            <span ng-show="objForm.bookDate.$error.required" class="msg-val">Book Date is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Booking Status: </td> <td><input type="text" name="bookStatus" ng-model="objCtrl.obj.bookStatus" required/> 
                            <span ng-show="objForm.bookStatus.$error.required" class="msg-val">Booking Status is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Total Booked Seat: </td> <td><input type="text" name="tbookedSeat" ng-model="objCtrl.obj.tbookedSeat" required/> 
                            <span ng-show="objForm.tbookedSeat.$error.required" class="msg-val">Booking Status is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Payment Status: </td> <td><input type="text" name="paymentStatus" ng-model="objCtrl.obj.paymentStatus" required/> 
                            <span ng-show="objForm.paymentStatus.$error.required" class="msg-val">Payment Status is required.</span> </td>
                    </tr>
<!--                    <tr>
                        <td>Total Price: </td> <td><input type="text" name="totalPrice" ng-model="objCtrl.obj.totalPrice" required/> 
                            <span ng-show="objForm.totalPrice.$error.required" class="msg-val">Total Price is required.</span> </td>
                    </tr>-->
                   
                     <tr>
                        <td>Ticket Number: </td> <td><input type="text" name="ticketNumber" ng-model="objCtrl.obj.ticketNumber" required/> 
                            <span ng-show="objForm.ticketNumber.$error.required" class="msg-val">Ticket Number is required.</span> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Booking successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Booking already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add New Booking"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Booking"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Booking successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <br/>
            <table class="table">
                <tr style="background-color: #2b542c"><th>ID </th> 
                    <th>User Name</th>
                    <th>Departure Date</th> 
                    <th>Booked Date</th> 
                    <th>Booking Status</th>
                    <th>Total Booked Seat</th>
                    <th>Payment Status</th>
                    <th>Ticket Price</th>
                    <th>Ticket Number</th>
                      <th>Total Price</th>
                      <th>Action</th>
                </tr>



                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.bookId"></span></td>
                    <td><span ng-bind="row.user.userName"></span></td>
                    <td><span ng-bind="row.trainSchedule.deparDate"></span></td>
                    <td><span ng-bind="row.bookDate"></span></td>
                    <td><span ng-bind="row.bookStatus"></span></td>
                    <td><span ng-bind="row.tbookedSeat"></span></td>
                    <td><span ng-bind="row.paymentStatus"></span></td>
                    <td><span ng-bind="row.coachInfo.ticketPrice"></span></td>
                    <td><span ng-bind="row.ticketNumber"></span></td>
                     <td><span ng-bind="row.totalPrice"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.bookId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.bookId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.bookId == objCtrl.updatedId" class="msg-success">Booking successfully updated.</span> </td> 
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
        <script src="${pageContext.request.contextPath}/static/js/controller/booking_info_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
          <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/app.css"/>  
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css"/>
    </body>
</html> 