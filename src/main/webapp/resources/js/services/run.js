angular.module('escapeBoxApp')
.factory('Run', function RunFactory($resource){
	return $resource("/api/runs/:id", {}, {});
})