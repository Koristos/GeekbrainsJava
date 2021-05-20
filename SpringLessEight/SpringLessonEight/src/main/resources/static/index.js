angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/products';


    $scope.addProduct = function () {
        console.log($scope.NewProduct)
        $http.post(contextPath, $scope.NewProduct)
            .then(function (){
                $scope.NewProduct = null
                $scope.fillTable();
            })

    };

    $scope.fillTable = function () {
        $http({
            url: contextPath,
            method: 'GET'
        }).then(function (response) {
            $scope.Products = response.data;
        });
    };



    $scope.deleteProductById = function (id){
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

    $scope.listPage = function (curPage, direction) {
        $http({
            url: contextPath,
            method: 'GET',
            params: {
                'curPage': curPage,
                'direction': direction,
            }
        }).then(function (response) {
            $scope.Products = response.data;
        });
    };

    $scope.fillTable();

});
