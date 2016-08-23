angular.module('escapeBoxApp')
.controller('roomAppController', function($scope, Room){

    $scope.rooms = [];

	$scope.getRooms = function(){
        $scope.rooms = Room.query();
	}

	// Initialization
        $scope.getRooms();

    $scope.createRoom = function(){
        var room = new Room();
        room.name = $scope.inputRoom.name;

        room.$save().then(function(){
            $scope.getRooms();
            console.log("success");
        });
    }

});