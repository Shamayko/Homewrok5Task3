angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

        $scope.checkSum = function () {
            $http.get(contextPath + '/products/sum')
                .then(function (response) {
                    $scope.sumTotal = response.data;
                });
        };

        $scope.checkSum();

    $scope.nullProduct = function (productId) {
        $http.get(contextPath + '/products/null/' + productId)
            .then(function (response) {
                $scope.loadProducts();
                $scope.checkSum();
            });
    }

    $scope.changeQuantity = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_quantity',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
            $scope.checkSum();
        });
    }

    $scope.loadProducts();
});