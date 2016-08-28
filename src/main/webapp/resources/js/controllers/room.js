angular.module('escapeBoxApp')
.controller('roomController', function($scope, Room, Scenario){

    $scope.rooms = [];
    $scope.scenarios = [];
    $scope.inputRoom = {};

	$scope.refresh = function(){
        $scope.rooms = Room.query();
        $scope.scenarios = Scenario.query();
        refreshRooms();
	}

    refreshRooms = function(){
        for (var i = 0; i < $scope.rooms.length; i++){
            $scope.rooms[i].selectedScenario = $scope.rooms[i].scenario;
        }
    }

	// Initialization
        $scope.refresh();

    $scope.createRoom = function(){
        if ($scope.inputRoom.name == null)
            return;

        var room = new Room();
        room.name = $scope.inputRoom.name;

        room.$save().then(function(){
            $scope.refresh();
            console.log("success");
        });
    }

    $scope.startRun = function(room){
        if (room.scenario == null)
            return;

        Room.start({id:room.id}, $scope.refresh);
    }

    $scope.deleteRoom = function (room){
        Room.delete({id:room.id}, $scope.refresh)
    }

    $scope.setScenario = function(room, scenario){
        console.log("set scenario room: "+room.name+" scenario "+scenario.id);
        Room.associate({roomId:room.id, scenarioId:scenario.id}, $scope.refresh);
    }

    $scope.checkCreateButton = function (){
        return ($scope.inputRoom.name == undefined || $scope.inputRoom.name.length == 0);
    }

});