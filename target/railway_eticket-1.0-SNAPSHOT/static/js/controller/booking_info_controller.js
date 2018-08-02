'use strict';

app.factory('User', ['$resource', function ($resource) {
       return $resource('http://localhost:8080/railway_eticket/user/userlist/:userId', {userId: '@userId'},
        {
            updateUser: {method: 'PUT'}
        }
        );
    }]);
app.factory('CoachInfo', ['$resource', function ($resource) {
       return $resource('http://localhost:8080/railway_eticket/coach/coachlist/:coachId', {coachId: '@coachId'},
        {
            updateUser: {method: 'PUT'}
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
app.factory('Booking', ['$resource', function ($resource) {
       return $resource('http://localhost:8080/railway_eticket/booking/bookinglist/:bookId', {bookId: '@bookId'},
        {
         updateBook: {method: 'PUT'}
        }
        );
    }]);


app.controller('BookingController', ['$scope', 'Booking', 'User','CoachInfo', 'TrainSchedule', function ($scope, Booking, User,CoachInfo, TrainSchedule) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.obj = new Booking();
        ob.obj2 = new User();
          ob.obj4 = new  CoachInfo();
        ob.obj3 = new TrainSchedule();
        ob.fetchAllObject = function () {
            ob.objArray = Booking.query();
            $scope.names= ob.objArray2 = User.query();
            $scope.nams= ob.objArray3 = TrainSchedule.query();
                 $scope.namss= ob.objArray4 = CoachInfo.query();
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
            ob.obj = Booking.get({bookId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateBook(function (object) {
                    console.log(object);
                    ob.updatedId = object.bookId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Booking.delete({bookId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Booking();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new Booking();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


