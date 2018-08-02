<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> User </title>
    </head>
    <body ng-app="myApp" style="background-color: #c1e2b3">
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
       
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
        <div ng-controller="UserController as objCtrl">
            <h1> User Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New User </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update User for ID: {{ objCtrl.obj.userId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>User Type</td>
                        <td>
                            <select ng-model="objCtrl.obj.userType" ng-options="x.utypeName for x in names">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>User Name: </td> <td><input type="text" name="userName" ng-model="objCtrl.obj.userName" required/> 
                            <span ng-show="objForm.userName.$error.required" class="msg-val"> *</span> </td>
                    </tr>
                    <tr>
                        <td>User Password: </td> <td><input type="text" name="userPass" ng-model="objCtrl.obj.userPass" required/> 
                            <span ng-show="objForm.userPass.$error.required" class="msg-val">*</span> </td>
                    </tr>
                    <tr>
                        <td>User Phone: </td> <td> <input type="text" name="userPhone" ng-model="objCtrl.obj.userPhone" required/> 
                            <span ng-show="objForm.userPhone.$error.required" class="msg-val">*</span> </td>
                    </tr>
                    <tr>
                        <td>User Email: </td> <td> <input type="text" name="userEmail" ng-model="objCtrl.obj.userEmail" required/> 
                            <span ng-show="objForm.userEmail.$error.required" class="msg-val">*</span> </td>
                    </tr>
                    <tr>
                        <td>User Address </td> <td> <input type="text" name="userAddress" ng-model="objCtrl.obj.userAddress" required/> 
                            <span ng-show="objForm.userAddress.$error.required" class="msg-val">*</span> </td>
                    </tr>


                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">User successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">User already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add User"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update User"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">User successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> 
                    <th>User Type</th> 
                    <th>User Name</th> 
                    <th>User Password</th>
                    <th>User Phone</th>
                    <th>User Email</th>
                    <th>User Address</th></tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.userId"></span></td>
                    <td><span ng-bind="row.userType.utypeName"></span></td>
                    <td><span ng-bind="row.userName"></span></td>
                    <td><span ng-bind="row.userPass"></span></td>
                    <td><span ng-bind="row.userPhone"></span></td>
                    <td><span ng-bind="row.userEmail"></span></td>
                    <td><span ng-bind="row.userAddress"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.userId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.userId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.userId == objCtrl.updatedId" class="msg-success">User successfully updated.</span> </td> 
                </tr>	
                <!--                <tr ng-repeat="row in objCtrl.objArray2">
                                    <td><span ng-bind="row.tspName"></span></td>
                                    
                                </tr>-->
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/user_info_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
          <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/app.css"/>  
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css"/>
    </body>
</html> 