angular.module('escapeBoxApp')
.controller('scenarioController', function($scope, Scenario){

    $scope.scenarios = [];
    $scope.inputFormScenario = {};

	$scope.refresh = function(){
	    $scope.scenarios = Scenario.query();
	}

	// Initialization
    $scope.refresh();


    $scope.createScenario = function(){
        var scenario = new Scenario();
        scenario.name = $scope.inputFormScenario.name;
        scenario.numberOfPlayers = $scope.inputFormScenario.nbr;
        scenario.duration = $scope.inputFormScenario.duration;

        scenario.$save().then(function(){
            $scope.refresh();
        })
    }
    
    $scope.deleteScenario = function(scenario){
        Scenario.delete({id:scenario.id}, $scope.refresh);
    }
});