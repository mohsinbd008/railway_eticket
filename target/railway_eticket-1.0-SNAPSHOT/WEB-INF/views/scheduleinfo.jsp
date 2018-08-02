<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Train Schedule </title>
    </head>
    <body ng-app="myApp" style="background-color: #67b168">
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
        <div ng-controller="TrainScheduleController as objCtrl">
            <h1> Train Schedule Information </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add Train Schedule </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Train Schedule for ID: {{ objCtrl.obj.scheduleId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Route</td>
                        <td>
                            <select ng-model="objCtrl.obj.route" ng-options="x.routeNo for x in names">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Train Name</td>
                        <td>
                            <select ng-model="objCtrl.obj.trainInfo" ng-options="y.trainName for y in nams">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Departure Date: </td> <td><input type="date" name="deparDate" ng-model="objCtrl.obj.deparDate" required/> 
                            <span ng-show="objForm.deparDate.$error.required" class="msg-val">Departure Date is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Departure Time: </td> <td><input type="time" name="deparTime" ng-model="objCtrl.obj.deparTime" required/> 
                            <span ng-show="objForm.deparTime.$error.required" class="msg-val">Departure Time is required.</span> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Train Schedule successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Train Schedule already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Schedeule"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Schedeule"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Train Schedule successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> 
                    <th>Route No</th>
                    <th>Train Name</th>
                    <th>Departure Date</th> 
                    <th>Departure Time</th> 


                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.scheduleId"></span></td>
                    <td><span ng-bind="row.route.routeNo"></span></td>
                    <td><span ng-bind="row.trainInfo.trainName"></span></td>
                    <td><span ng-bind="row.deparDate"></span></td>
                    <td><span ng-bind="row.deparTime"></span></td>

                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.scheduleId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.scheduleId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.scheduleId == objCtrl.updatedId" class="msg-success">Train Schedule successfully updated.</span> </td> 
                </tr>	
                <!--                <tr ng-repeat="row in objCtrl.objArray2">
                                    <td><span ng-bind="row.tspName"></span></td>
                                    
                                </tr>-->
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/train_schedule_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/app.css"/>  
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css"/>
    </body>
</html> 