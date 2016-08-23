<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
<title>Escape Game Dashboard</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-resource.js"></script>

<script src="resources/js/escapeBoxApp.js"></script>
<script src="resources/js/controllers/scenario.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome-4.6.3/css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="resources/css/white-blue-theme.css" type="text/css" media="screen,projection">

</head>

<body id="grad" ng-app="escapeBoxApp" ng-controller="scenarioAppController">

<%@ include file="/WEB-INF/views/navigationBar.jsp" %>

<h2>Scenario Management</h2>

<form class="form-inline">
  <div class="form-group">
    <label>Name</label>
    <input ng-model="inputFormScenario.name"type="text" class="form-control" placeholder="">
  </div>
  <div class="form-group">
    <label>Number of Players</label>
    <input ng-model="inputFormScenario.nbr" type="number" class="form-control" placeholder="">
  </div>
  <div class="form-group">
      <label>Duration in minutes</label>
      <input ng-model="inputFormScenario.duration" type="number" class="form-control" placeholder="">
    </div>
  <button ng-click="createScenario()" type="submit" class="btn btn-success">Create Scenario</button>
</form>

<h4>Scenario List</h4>
<ul ng-repeat="scenario in scenarios">
    <li><strong>{{scenario.name}}</strong> Number of players: {{scenario.numberOfPlayers}}
    Duration: {{scenario.duration}}
    <button ng-click="deleteScenario(scenario)" class="btn btn-danger">Delete Scenario</button>
    </li>
</ul>

</div>

</body>
</html>