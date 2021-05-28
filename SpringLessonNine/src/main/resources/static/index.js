angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';


    $scope.addProduct = function () {
        console.log($scope.NewProduct)
        $http.post(contextPath+'/products', $scope.NewProduct)
            .then(function (){
                $scope.NewProduct = null
                $scope.fillTable();
            })

    };

    $scope.addCategory = function () {
        console.log($scope.NewCategory)
        $http.post(contextPath+'/categories', $scope.NewCategory)
            .then(function (){
                $scope.NewCategory = null
                $scope.fillTable();
            })

    };

    $scope.fillTable = function (page = 1, category_id=null) {
        $http({
            url: contextPath+'/products',
            method: 'GET',
            params: {
                'curPage': page,
                "categoryId" : category_id
            }
        }).then(function (response) {
            $scope.Page = response.data;
        });
        $http({
            url: contextPath+'/categories',
            method: 'GET'
        }).then(function (response) {
            $scope.Categories = response.data;
        });
    };



    $scope.deleteProductById = function (id){
        $http({
            url: contextPath+'/products/'+id,
            method: 'DELETE',
        }).then(function (){
            $scope.fillTable();
        });
    };


    $scope.fillTable();

});
