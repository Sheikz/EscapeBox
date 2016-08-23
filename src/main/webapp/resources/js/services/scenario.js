angular.module('escapeBoxApp')
.factory('Scenario', function ScenarioFactory($resource){
	return $resource("/api/scenarios/:id", {}, {});
})