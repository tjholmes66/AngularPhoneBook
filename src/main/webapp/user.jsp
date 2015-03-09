<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="userManagerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>AngularJS User Manager</title>

<script data-require="angular.js@*" data-semver="1.2.13"
	src="http://code.angularjs.org/1.2.13/angular.js"></script>
	
<script type="text/javascript" src="./js/phonebook.js"></script>

<script type="text/javascript">

$scope.engineer = {
	    name: "Dani",
	    currentActivityId: 3
	};
	 
	$scope.activities =
	[
	    { id: 1, type: "Work", name: "Writing code" },
	    { id: 2, type: "Work", name: "Testing code" },
	    { id: 3, type: "Work", name: "Fixing bugs" },
	    { id: 4, type: "Play", name: "Dancing" }
	];

</script>

</head>

<body>
	<div ng-controller="userController">
		<div id="user-panel" class="fadein fadeout showpanel panel" ng-show="toggle">
			
			<div class="panel-heading">
				<i class="panel-title-icon fa fa-users"></i> <span
					class="panel-title">Recent Users</span>
				<div class="panel-heading-controls">
					<button ng-click="toggle = !toggle">Add New User</button>
					<button confirmed-click="archiveUsers()"
						ng-confirm-click="Would you like to archive completed users?">Clear
						completed users</button>
				</div>
			</div>
			
			<div>
				<div ng-repeat="user in users">
					<span> {{user.userPriority}} </span>
					<div>
						<input id="{{user.userId}}" type="checkbox"
							value="{{user.userId}}"
							ng-checked="selection.indexOf(user.userId) > -1"
							ng-click="toggleSelection(user.userId)" /> <label
							for="{{user.userId}}"></label>
					</div>
					<div ng-if="user.userStatus=='COMPLETED'">
						<a href="#" class="checkedClass"> {{user.userName}} <span
							class="action-status">{{user.userStatus}}</span>
						</a>
					</div>
					<div ng-if="user.userStatus=='ACTIVE'">
						<a href="#" class="uncheckedClass"> {{user.userName}} <span
							class="action-status">{{user.userStatus}}</span>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div id="add-user-panel" ng-hide="toggle">
			<div>
				<span>Add User</span>
				<div>
					<button ng-click="toggle = !toggle">Show All Users</button>
				</div>
			</div>
			<div>
				<div>
					<table>
						<tr>
							<td>User Name:</td>
							<td><input type="text" ng-model="userName" /></td>
						</tr>
						<tr>
							<td>User Description:</td>
							<td><input type="text" ng-model="userDesc" /></td>
						</tr>
						<tr>
							<td>User Status:</td>
							<td><select ng-model="userStatus"
								ng-options="status as status for status in statuses">
									<option value="">-- Select --</option>
							</select></td>
						</tr>
						<tr>
							<td>User Priority:</td>
							<td><select ng-model="userPriority"
								ng-options="priority as priority for priority in priorities">
									<option value="">-- Select --</option>
							</select></td>
						</tr>
						<tr>
							<td><br />
							<button ng-click="addUser()" class="btn-panel-big">Add
									New User</button></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	
	<select ng-model="engineer.currentActivityId"
        data-ng-options="a.id as a.name group by a.type for a in activities">               
	</select>
	
</body>
</html>