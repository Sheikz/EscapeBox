angular.module('escapeBoxApp')
.factory('Room', function RoomFactory($resource){
	return $resource("/api/rooms/:id", {}, {});
})