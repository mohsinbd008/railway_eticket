'use strict';


app.factory('User', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/railway_eticket/user/userLogin/:userId', {userId: '@userId'},
        {
            updateUser: {method: 'PUT'}
        }
        );
    }]);
//var app = angular.module('myApp.services', ['ngResource']);
//app.factory('TspFaculty', ['$resource', function ($resource) {
//        return {
//            faculty: $resource('http://localhost:8080/ProjectStarter/faculty/facultylist/:coachId', {coachId: '@coachId'}, {
//                query: {method: 'GET', params: {}, isArray: false},
//                updateFaculty: {method: 'PUT'}
//            }),
//            tsp: $resource('http://localhost:8080/ProjectStarter/tsp/tsplist/:tspId', {tspId: '@tspId'}, {
//                query: {method: 'GET', params: {}, isArray: false},
//                updateTsp: {method: 'PUT'}
//            })
//        };
//    }]);

//  https://stackoverflow.com/questions/17160771/angularjs-a-service-that-serves-multiple-resource-urls-data-sources

app.controller('UserLoginController', ['$scope', 'User',  function ($scope, User) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.obj = new User();
       
        ob.fetchAllObject = function () {
            ob.objArray = User.query();
         
        };
        //$scope.names = ob.objArray2;
        console.log($scope.names+"hello");
        ob.fetchAllObject();
        ob.userLogin = function () {
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
//        ob.editObject = function (id) {
//            console.log('Inside edit');
//            ob.obj = User.get({userId: id}, function () {
//                ob.flag = 'edit';
//            });
//        };
//        ob.updateObjectDetail = function () {
//            console.log('Inside update');
//            if ($scope.objForm.$valid) {
//                ob.obj.$updateUser(function (object) {
//                    console.log(object);
//                    ob.updatedId = object.userId;
//                    ob.reset();
//                    ob.flag = 'updated';
//                    ob.fetchAllObject();
//                });
//            }
//        };
//        ob.deleteObject = function (id) {
//            console.log('Inside delete');
//            ob.obj = User.delete({userId: id}, function () {
//                ob.reset();
//                ob.flag = 'deleted';
//                ob.fetchAllObject();
//            });
//        };
//        ob.reset = function () {
//            ob.obj = new User();
//            $scope.objForm.$setPristine();
//        };
//        ob.cancelUpdate = function (id) {
//            ob.obj = new User();
//            ob.flag = '';
//            ob.fetchAllObject();
//        };
    }]);


