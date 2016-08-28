<div ng-controller='navController'>
  <ul class="nav nav-pills">
    <li role="presentation" ng-class="{active: $route.current.activetab == 'home'}"><a href="#">Dashboard</a></li>
    <li role="presentation" ng-class="{active: $route.current.activetab == 'rooms'}"><a href="#/rooms">Rooms</a></li>
    <li role="presentation" ng-class="{active: $route.current.activetab == 'scenarios'}"><a href="#/scenarios">Scenarios</a></li>
  </ul>
</div>