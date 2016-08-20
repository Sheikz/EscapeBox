var escapeBoxApp = angular.module('escapeBoxApp', []);

escapeBoxApp.controller('roomAppController', function($scope, $http){

    $scope.rooms = [];

	$scope.getRooms = function(){
		var url = "api/room/list";
		console.log("calling url: ["+url+"]");
		$http.get(url).success(function (data){
			$scope.rooms = data;
		}).error(function(data, status){
			console.log("Error while retrieving API: "+url);
		});
	}

	// Initialization
        $scope.getRooms();

    $scope.createRoom = function(){
        var url = "api/room/create";
        var room = {};
        room.name = $scope.inputRoom.name;

        $http({
            method: 'POST',
            url: url,
            data: {
                name: room.name,
            }
        }).success(function (data){
            $scope.getRooms();
            console.log("Successfully created room ["+room.name+"]");
        }).error(function (data){
            console.log("Error while creating room ["+room.name+"]");
        });
    }

});