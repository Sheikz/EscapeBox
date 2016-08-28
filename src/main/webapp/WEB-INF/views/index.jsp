<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
<title>Escape Game Dashboard</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-resource.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-route.js"></script>

<script src="resources/js/escapeBoxApp.js"></script>
<script src="resources/js/routes.js"></script>
<script src="resources/js/controllers/room.js"></script>
<script src="resources/js/controllers/scenario.js"></script>
<script src="resources/js/controllers/run.js"></script>
<script src="resources/js/controllers/nav.js"></script>
<script src="resources/js/services/room.js"></script>
<script src="resources/js/services/scenario.js"></script>
<script src="resources/js/services/run.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome-4.6.3/css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="resources/css/white-blue-theme.css" type="text/css" media="screen,projection">

</head>
<body ng-app='escapeBoxApp'>

<%@ include file="/WEB-INF/views/navigationBar.jsp" %>

<div ng-view>

</body>
</html>