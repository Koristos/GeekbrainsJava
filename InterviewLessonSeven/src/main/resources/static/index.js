angular.module('app', []).controller('indexController', function ($scope, $http) {
	const contextPath = 'http://localhost:8080/students/';


	$scope.addStudent = function () {
		console.log($scope.NewStudent)
		$http.post(contextPath, $scope.NewStudent)
				.then(function (){
					$scope.NewStudent = null
					$scope.fillTable();
				})

	};

	$scope.fillTable = function () {
		$http({
			url: contextPath,
			method: 'GET'
		}).then(function (response) {
			$scope.Students = response.data;
		});
	};



	$scope.deleteStudentById = function (id){
		$http({
			url: contextPath,
			method: 'DELETE',
			params: {
				'id': id,
			}
		}).then(function (){
			$scope.fillTable();
		});
	};

	$scope.fillTable();

});