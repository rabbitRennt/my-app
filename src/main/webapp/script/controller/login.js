'use strice';

angular.module('myApp').controller(
		'LoginCtrl',
		function($scope, $state , $http) {
			console.log('登录页面');

			// 数据绑定
			$scope.helloTo = {};
			$scope.helloTo.title = " AngularJS ";

			$scope.student = {
				username : "TestAdmin",
				password : "123456",
				param : function() {
					var studentObject;
					studentObject = $scope.student;
					return studentObject.username + $scope.helloTo.title
							+ studentObject.password;
				}
			};
			
			$scope.message=$scope.student.param();
			
			$scope.login = function(event) {
				console.log(event);
				var url="login/aa"
				$http.get(url).success( function(response) {
                    $scope.students = response; 
                    $scope.message="test";
                 });
				// $state.go('index');
			}
		})