<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Spring MVC 4 REST + AngularJS </title>
              <header class="container-fluid text-center"style="background-image: url(images/innovative-banner1.jpg)" >
    <h1>Innovative World of Technology</h1>
</header>
    </head>
    
    <body ng-app="myApp" style="background-color:lightblue">
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
       
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
          <center>
              <div ng-controller="RouteController as objCtrl">
          
            <h1> Route Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New Route </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Route for ID: {{ objCtrl.obj.routeId}} </h3> 
                            </div> </td>
                    </tr>
                     <tr>
                        <td>Route No: </td> <td><input type="text" name="routeNo" ng-model="objCtrl.obj.routeNo" required/> 
                            <span ng-show="objForm.routeNo.$error.required" class="msg-val">Route No is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Route Name: </td> <td><input type="text" name="routeName" ng-model="objCtrl.obj.routeName" required/> 
                            <span ng-show="objForm.routeName.$error.required" class="msg-val">Route Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Source </td> <td> <input type="text" name="source" ng-model="objCtrl.obj.source" required/> 
                            <span ng-show="objForm.source.$error.required" class="msg-val">Source is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Destination</td> <td> <input type="text" name="destination" ng-model="objCtrl.obj.destination" required/> 
                            <span ng-show="objForm.destination.$error.required" class="msg-val">Destination is required.</span> </td>
                    </tr>
                   

                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Route successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Route already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Route"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Route"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Route successfully deleted.</span>
                    </tr>
                </table> 
                  
            </form>
             
            <table class="table table-striped">
            
                <tr><th>ID </th> <th>Name</th> <th>Route No</th> <th>Source</th> <th>Destination</th><th>Action</th></tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.routeId"></span></td>
                    <td><span ng-bind="row.routeNo"></span></td>
                    <td><span ng-bind="row.routeName"></span></td>
                    <td><span ng-bind="row.source"></span></td>
                    <td><span ng-bind="row.destination"></span></td>

                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.routeId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.routeId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.routeId == objCtrl.updatedId" class="msg-success">Route successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
               </center>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/route_info_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/app.css"/>  
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css"/>
    </body>
</html> 