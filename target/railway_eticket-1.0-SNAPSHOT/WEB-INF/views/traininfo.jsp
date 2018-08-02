<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Spring MVC 4 REST + AngularJS </title>
<!--              <header class="container-fluid text-center"style="background-image: url(images/innovative-banner1.jpg)" >
    <h1>Bangladesh Railway E-Ticketing</h1>
</header>-->
<style>
    h1{color: darkslategray;font-size:large
    ;font-family: sans-serif;font-size-adjust: inherit}
    .title{
        text-orientation: upright;
        font-size: 32px;
    
    }
  

</style>
    </head>
    
    <body ng-app="myApp">
        <div class="container-fluid">
        <div id="header" style="height: 20%;background-color: #5bc0de">
            <div class="col-sm-3">
            <div id="header1"><img src="${pageContext.request.contextPath}/static/images/Bangladeshrailwaylogo.jpg" width="100" height="100" /></div>
            </div>
           
                <div class="title">  BANGLADESH RAILWAY E-TICKETING SERVICE</div><br/>
                <small style="font-size:14px; color:#797979"> BANGLADESH RAILWAY E-TICKETING SERVICE</small><br/><br/>
            </div>
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
              <div ng-controller="TrainInfoController as objCtrl">
          
                  <h1 style="color: green">Detailed Train Information </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New Train </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Train for ID: {{ objCtrl.obj.trainId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Train Name: </td> <td><input type="text" name="trainName" ng-model="objCtrl.obj.trainName" required/> 
                            <span ng-show="objForm.trainName.$error.required" class="msg-val">Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Off Day </td> <td> <input type="text" name="offDay" ng-model="objCtrl.obj.offDay" required/> 
                            <span ng-show="objForm.offDay.$error.required" class="msg-val">Off Day is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Train Type </td> <td> <input type="text" name="trainType" ng-model="objCtrl.obj.trainType" required/> 
                            <span ng-show="objForm.trainType.$error.required" class="msg-val">Train Type is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Capacity </td> <td> <input type="text" name="capacity" ng-model="objCtrl.obj.capacity" required/> 
                            <span ng-show="objForm.capacity.$error.required" class="msg-val">Capacity is required.</span> </td>
                    </tr>

                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Train successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Train already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Train"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Train"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Train successfully deleted.</span>
                    </tr>
                </table> 
                  
            </form>
             
            <table>
            
                <tr><th>ID </th> <th>Name</th> <th>Off Day</th> <th>Train Type</th> <th>Capacity</th></tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.trainId"></span></td>
                    <td><span ng-bind="row.trainName"></span></td>
                    <td><span ng-bind="row.offDay"></span></td>
                    <td><span ng-bind="row.trainType"></span></td>
                    <td><span ng-bind="row.capacity"></span></td>

                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.trainId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.trainId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.trainId == objCtrl.updatedId" class="msg-success">Train successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>

               </center>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/train_info_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
           <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/app.css"/>  
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css"/>
    <div class="footer" style="padding-top: 20px">
                <footer class="container-fluid text-center">
                    <p style="color: whitesmoke">@Powered by innovativeworld.com.bd</p>
                </footer>
            </div>
        </div>
    </body>
</html> 