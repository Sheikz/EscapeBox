angular.module('escapeBoxApp')
.controller('roomAppController', function($scope, Room){

    $scope.rooms = [];

	$scope.refresh = function(){
        $scope.rooms = Room.query();
	}

	// Initialization
        $scope.refresh();

    $scope.createRoom = function(){
        var room = new Room();
        room.name = $scope.inputRoom.name;

        room.$save().then(function(){
            $scope.refresh();
            console.log("success");
        });
    }

    $scope.deleteRoom = function (room){
        Room.delete({id:room.id}, $scope.refresh)
    }

});