angular.module('escapeBoxApp')
.controller('runController', function($scope, $routeParams, Room, Scenario, Run){

    $scope.runId = $routeParams.id
    $scope.run = Run.get({id:$routeParams.id})

});