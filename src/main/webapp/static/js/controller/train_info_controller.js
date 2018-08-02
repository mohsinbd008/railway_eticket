'use strict';

app.factory('TrainInfo', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/railway_eticket/train/trainlist/:trainId', {trainId: '@trainId'},
	{
		updateTrain: {method: 'PUT'}
	}
    );
}]);
//angular.module('myApp.services', ['ngResource']).
//  factory("geoProvider", function($resource) {
//    return {
//      states: $resource('../data/states.json', {}, {
//        query: { method: 'GET', params: {}, isArray: false }
//      }),
//      countries: $resource('../data/countries.json', {}, {
//        query: { method: 'GET', params: {}, isArray: false }
//      })
//    };
//  }); https://stackoverflow.com/questions/17160771/angularjs-a-service-that-serves-multiple-resource-urls-data-sources

app.controller('TrainInfoController', ['$scope', 'TrainInfo', function($scope, TrainInfo) {
    var ob = this;
    ob.objArray=[];
    ob.obj = new TrainInfo(); 
    ob.fetchAllObject = function(){
        ob.objArray = TrainInfo.query();
       // console.log(objArray);
    };
    ob.fetchAllObject();
    ob.addObject = function(){
	console.log('Inside save');
	if($scope.objForm.$valid) {
	  ob.obj.$save(function(object){
	     console.log(object); 
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAllObject();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editObject = function(id){
	    console.log('Inside edit');
        ob.obj = TrainInfo.get({ trainId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updateTrain(function(object){
    		console.log(object); 
		ob.updatedId = object.trainId;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = TrainInfo.delete({ trainId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new TrainInfo();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new TrainInfo();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 


