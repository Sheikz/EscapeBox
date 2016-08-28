angular.module('escapeBoxApp')
.factory('Room', function RoomFactory($resource){
	return $resource("/api/rooms/:id", {}, 
		{
			'associate': {
				method:'POST',
				params: {roomId: '@roomId', scenarioId: '@scenarioId'},
				url: '/api/rooms/:roomId/associate/:scenarioId'
			},
			'start': {
				method:'POST',
				params: {id: '@id'},
				url: '/api/rooms/:id/start'
			}
		});
})