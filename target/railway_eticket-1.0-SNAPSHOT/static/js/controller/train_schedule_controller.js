'use strict';

app.factory('Route', ['$resource', function ($resource) {
       return $resource('http://localhost:8080/railway_eticket/route/routelist/:routeId', {routeId: '@routeId'},
        {
            updateRoute: {method: 'PUT'}
        }
        );
    }]);
app.factory('TrainInfo', ['$resource', function ($resource) {
       return $resource('http://localhost:8080/railway_eticket/train/trainlist/:trainId', {trainId: '@trainId'},
        {
         updateTrain: {method: 'PUT'}
        }
        );
    }]);
app.factory('TrainSchedule', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/railway_eticket/schedule/schedulelist/:scheduleId', {scheduleId: '@scheduleId'},
        {
            updateObject: {method: 'PUT'}
        }
        );
    }]);

app.controller('TrainScheduleController', ['$scope', 'TrainSchedule', 'Route', 'TrainInfo', function ($scope, TrainSchedule, Route, TrainInfo) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.obj = new TrainSchedule();
        ob.obj2 = new Route();
        ob.obj3 = new TrainInfo();
        ob.fetchAllObject = function () {
            ob.objArray = TrainSchedule.query();
            $scope.names= ob.objArray2 = Route.query();
            $scope.nams= ob.objArray3 = TrainInfo.query();
        };
        //$scope.names = ob.objArray2;
        console.log($scope.names+"hello");
        ob.fetchAllObject();
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.objForm.$valid) {
                //ob.obj.tspInfo= ob.obj2;
                ob.obj.$save(function (object) {
                    console.log(object);
                    ob.flag = 'created';
                    ob.reset();
                    ob.fetchAllObject();
                },
                        function (err) {
                            console.log(err.status);
                            ob.flag = 'failed';
                        }
                );
            }
        };
        ob.editObject = function (id) {
            console.log('Inside edit');
            ob.obj = TrainSchedule.get({scheduleId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.scheduleId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = TrainSchedule.delete({scheduleId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new TrainSchedule();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new TrainSchedule();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


