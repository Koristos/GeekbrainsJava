angular.module('app', []).controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';


    $scope.fillCart = function () {
        $http({
            url: contextPath+'/cart',
            method: 'GET',
        }).then(function (response) {
            $scope.Cart = response.data;
        });
    };


    $scope.deleteProduct = function (id){
        $http({
            url: contextPath + '/cart/' + id,
            method: 'DELETE',
        }).then(function (){
            $scope.fillCart();
        });
    };


    $scope.fillCart();

});
