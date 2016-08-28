angular.module('escapeBoxApp')
.config(function($routeProvider){
$routeProvider
	.when('/home', {
    	templateUrl: 'resources/templates/home.html',
    	controller: 'roomController',
    	activetab: 'home'
    })
    .when('/rooms', {
    	templateUrl: 'resources/templates/rooms.html',
    	controller: 'roomController',
    	activetab: 'rooms'
    })
    .when('/scenarios', {
    	templateUrl: 'resources/templates/scenarios.html',
    	controller: 'scenarioController',
    	activetab: 'scenarios'
    })
    .when('/run/:id', {
        	templateUrl: 'resources/templates/run.html',
        	controller: 'runController',
        })
    .otherwise({redirectTo:'/home'});
})
