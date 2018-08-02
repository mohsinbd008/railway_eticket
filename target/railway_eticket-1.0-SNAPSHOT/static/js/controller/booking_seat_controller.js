'use strict';

app.factory('CoachInfo', ['$resource', function ($resource) {
       return $resource('http://localhost:8080/railway_eticket/coach/coachlist/:coachId', {coachId: '@coachId'},
        {
            updateCoach: {method: 'PUT'}
        }
        );
    }]);

app.factory('Booking', ['$resource', function ($resource) {
       return $resource('http://localhost:8080/railway_eticket/booking/bookinglist/:bookId', {bookId: '@bookId'},
        {
         updateBooking: {method: 'PUT'}
        }
        );
    }]);
app.factory('BookingSeat', ['$resource', function ($resource) {
       return $resource('http://localhost:8080/railway_eticket/seatbooking/seatbookinglist/:boSeatId', {boSeatId: '@boSeatId'},
        {
            updateObject: {method: 'PUT'}
        }
        );
    }]);



app.controller('SeatBookingController', ['$scope', 'BookingSeat', 'CoachInfo', 'Booking', function ($scope, BookingSeat, CoachInfo, Booking) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.obj = new BookingSeat();
        ob.obj2 = new CoachInfo();
        ob.obj3 = new Booking();
        ob.fetchAllObject = function () {
            ob.objArray = BookingSeat.query();
            $scope.names= ob.objArray2 = CoachInfo.query();
            $scope.nams= ob.objArray3 = Booking.query();
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
            ob.obj = BookingSeat.get({boSeatId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.boSeatId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = BookingSeat.delete({boSeatId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new BookingSeat();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new BookingSeat();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


