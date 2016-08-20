var escapeBoxApp = angular.module('escapeBoxApp', []);

escapeBoxApp.controller('scenarioAppController', function($scope, $http){

    $scope.scenarios = [];
    $scope.inputFormScenario = {};

	$scope.getScenarios = function(){
		var url = "api/scenario/list";
		console.log("calling url: ["+url+"]");
		$http.get(url).success(function (data){
			$scope.scenarios = data;
		}).error(function(data, status){
			console.log("Error while retrieving API: "+url);
		});
	}

	// Initialization
        $scope.getScenarios();


    $scope.createScenario = function(){
        var url = "api/scenario/create";
        var scenario = {};
        scenario.name = $scope.inputFormScenario.name;
        scenario.numberOfPlayers = $scope.inputFormScenario.nbr;
        scenario.duration = $scope.inputFormScenario.duration;

        $http({
        	method: 'POST',
        	url: url,
        	data: {
        		name: scenario.name,
        		numberOfPlayers : scenario.numberOfPlayers,
        		duration: scenario.duration
        	}
        }).success(function (data){
            $scope.getScenarios();
        	console.log("Successfully created scenario ["+scenario.name+"]");
        }).error(function (data){
        	console.log("Error while creating scenario ["+scenario.name+"]");
        });
    }

    $scope.startRun = function (scenario){
        var url = "api/run/start/"+scenario.id;
        $http({
            method: 'PUT',
            url: url
        }).success(function (data){;
            console.log("Successfully created run for scenario["+scenario.name+"]");
        }).error(function (data){
            console.log("Error while creating run for scenario["+scenario.name+"]");
        });
    }
    
    $scope.deleteScenario = function(scenario){
    	var url = "api/scenario/delete/"+scenario.id;

        $http({
        	method: 'DELETE',
        	url: url
        }).success(function (data){
            $scope.getScenarios();
        	console.log("Successfully deleted scenario ["+scenario.name+"]");
        }).error(function (data){
        	console.log("Error while deleting scenario ["+scenario.name+"]");
        });
    }
});