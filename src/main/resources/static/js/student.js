 var myApp = angular.module('myApp', ['ngRoute', 'ui.bootstrap', 'rzModule']);

    // configure our routes
    myApp.config(['$routeProvider',function($routeProvider) {
        $routeProvider
		
			// route for the student home page
            .when('/', {
                templateUrl : 'pages/home.html',
                controller  : 'studentHomeController'
            })

            // route for the student enter details page
            .when('/enterDetails', {
                templateUrl : 'pages/studentform.html',
                controller  : 'studentController'
            })

            // route for the display student page
            .when('/displayStudent', {
                templateUrl : 'pages/displaystudent.html',
                controller  : 'displayController'
            })

            // route for the slider page
            .when('/slider', {
                templateUrl : 'pages/slider.html',
                controller  : 'sliderController'
            });
    }]);
	
	// create the controller and inject Angular's $scope
    myApp.controller('studentHomeController', ['$scope',function($scope) {
        $scope.successalert = false;
        $scope.message = 'Please share your details!';
		
    }]);
	
	// save student data
	myApp.factory('studentService',['$http', '$q', function ($http, $q){	
		var factory  = {};
		factory.savestudent = function(student) {
			var deferred = $q.defer();
			$http.post('add', student
			).success( function(data, status) {
				console.log(status);
				factory.statusvalue = "success";
				deferred.resolve(factory.statusvalue);
			}).error(function(data, status) {
				console.log(status);
				factory.statusvalue = "failure";
				deferred.reject(factory.statusvalue);
			});
			return deferred.promise;
		}
		return factory;
	}]);

    // create the controller and inject Angular's $scope
    myApp.controller('studentController', ['$scope', 'studentService', '$timeout', '$window' ,function($scope, studentService, $timeout, $window) {
        $scope.successalert = false;
		$scope.mySwitch = true;
        $scope.message = 'Please share your details!';
		
		$scope.validateFun = function() {
			if(undefined != $scope.student.name && undefined != $scope.student.age && undefined != $scope.student.id) {
				$scope.mySwitch = false;
			} else {
				$scope.mySwitch = true;
			}
		}
		
		$scope.myFunc = function (student) {			
			$scope.factObj = studentService.savestudent(student).then(function(data){
				if("success" === data) {
					$scope.successalert = true;
				}
				$timeout(function () {
				$scope.successalert = false;
					$timeout(function () {
					$window.location.href = '#displayStudent';
					}, 500);
				}, 2000);	
			});		
		}	
    }]);
	
	// display student data
	myApp.factory('displayService', ['$http', '$q', function ($http, $q){	
		var factory  = {};
		factory.displaystudent = function() {
			var deferred = $q.defer();
			$http.get('view').success( function(response) {
				deferred.resolve(response);
			}).error(function(response) {
				deferred.reject(response);
			});
			return deferred.promise;
		}
		return factory;
	}]);
	
	// update student data
	myApp.factory('updateService', ['$http', '$q', function ($http, $q){		
		var factory  = {};
		factory.updatestudent = function(student) {
			var deferred = $q.defer();
			$http.put('update/'+student.id, student
			).success( function(response) {
				console.log(response);
				deferred.resolve(response);
			}).error(function(response) {
				deferred.reject(response);
			});
			return deferred.promise;
		}
		return factory;
	}]);
	
	// delete student data
	myApp.factory('deleteService', ['$http', '$q', function ($http, $q){		
		var factory  = {};
		factory.deletestudent = function(student) {
			var deferred = $q.defer();
			$http.delete('delete/'+student.id).success( function(response) {
				deferred.resolve(response);
			}).error(function(response) {
				deferred.reject(response);
			});
			return deferred.promise;
		}
		return factory;
	}]);

    myApp.controller('displayController', ['$scope', 'displayService', 'updateService', 'deleteService', function($scope, displayService, updateService, deleteService) {
        $scope.message = 'Student Details!';
		$scope.factObj = displayService.displaystudent().then(function(data){
			console.log(data);
			$scope.studentArray = data;
			$scope.studentArray.selectedstudent = {};
		});	
		
		$scope.getTemplate = function (student) {
        if (student.id === $scope.studentArray.selectedstudent.id) return 'edit';
        else return 'display';
		};
		
		$scope.editFun = function (student) {
        $scope.studentArray.selectedstudent = angular.copy(student);
		};
		
		$scope.reset = function () {
        $scope.studentArray.selectedstudent = {};
		};
		
		$scope.saveFun = function (student) {
			console.log(student._id);
			$scope.factObj = updateService.updatestudent(student).then(function(data){
			console.log(data);
			$scope.studentArray = data;
			$scope.reset();
		});
		}
		
		$scope.deleteFun = function (student) {
		console.log(student);
			$scope.factObj = deleteService.deletestudent(student).then(function(data){
			console.log(data);
			$scope.studentArray = data;
			$scope.reset();
		});
		}
    }]);

    myApp.controller('sliderController', ['$scope', function($scope) {
		$scope.message = 'Slider!';
		$scope.slider = {
			value: 12,
			floor: 0,
        ceil: 500,
        value: 100,
			options: {
			 	showSelectionBar: true
			}
		};
    }]);