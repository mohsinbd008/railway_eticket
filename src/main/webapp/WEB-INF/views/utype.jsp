<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Spring MVC 4 REST + AngularJS </title>
        <style>
body {
    background-image: url("WEB-INF/images/train1.jpg");
}
</style>
    </head>
    <body ng-app="myApp" style="background-color:lightblue">
    <center>
        <div ng-controller="UserTypeController as objCtrl">

            <h1> User TYPE Info </h1>
            <form name="objForm" method="POST"style="background-image: url(images/train1.jpg)">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New User Type </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update User Type for ID: {{ objCtrl.obj.utypeId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>User Type: </td> <td><input type="text" name="utypeName" ng-model="objCtrl.obj.utypeName" required/> 
                            <span ng-show="objForm.utypeName.$error.required" class="msg-val">User Type is required.</span> </td>
                    </tr>

                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">User Type successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">User Type already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add User Type"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update User Type"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">User Type successfully deleted.</span>
                    </tr>
                </table> 

            </form>

            <table>

                <tr><th>ID </th> <th>User Type</th> </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.utypeId"></span></td>
                    <td><span ng-bind="row.utypeName"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.utypeId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.utypeId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.utypeId == objCtrl.updatedId" class="msg-success">user type successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
    </center>
    <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/controller/user_type_controller.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
</body>
</html> 