var userApp = angular.module("userApp", [ 'ngRoute', 'ngResource' ]);

userApp.config(function($routeProvider)
{
	$routeProvider.when('/users/new', 
	{
		controller : 'NewUserCtrl',templateUrl : 'views/newuser.html'
	}).when('/users/:userId',
	{
		controller : 'UsersByIdCtrl',
		templateUrl : 'views/userbyid.html'	
	}).when('/users',
	{
		controller : 'UsersCtrl',
		templateUrl : 'views/users.html'	
	}).otherwise(
	{
		controller : 'SpaCtrl',
		templateUrl: 'views/spahome.html'
    });
});


userApp.factory( 'userservice', [ '$resource', function( $resource )
{
	return new User( $resource );
}] );
 
function User( resource )
{ 
	this.resource = resource; 
 
	this.createUser = function ( user, scope )
	{
		// 
		// Save Action Method
		//
		var User = resource('/users/new');
		
		User.save(user, function(response)
		{
			scope.message = response.message;
		});		
	}
 
	this.getUser = function ( id, scope )
	{
		//
		// GET Action Method
		//                   http://localhost:8080/phonebook-backend-ws/rest/users
		var User = resource('http://localhost:8080/phonebook-backend-ws/rest/users/userId/:userId', {userId:'@userId'});
		
		User.get( {userId:id}, function(user)
		{
			scope.user = user;
		})
	}
 
	this.getUsers = function( scope )
	{
		//
		// Query Action Method
		//
		var Users = resource('http://localhost:8080/phonebook-backend-ws/rest/users');
		
		Users.query(function(users)
		{
			scope.users = users;
		});
	}
}



//Controller when the main page/view loads
userApp.controller("SpaCtrl", [ '$scope', function($scope) {			
} ]);
// Controller for All Users View
userApp.controller("UsersCtrl", [ '$scope','userservice', function($scope, userservice) {	
	userservice.getUsers( $scope );		
} ]);
// Controller for New User View
userApp.controller("NewUserCtrl", [ '$scope','userservice', function($scope, userservice) {				
 
	userservice.getUsers( $scope );	
 
	$scope.createNewUser = function(){
		var newuser = { 'firstname':$scope.firstname, 'lastname': $scope.lastname, 'address':$scope.address, 'email':$scope.email };
		// Call UserService to create a new user
		//
		userservice.createUser ( newuser, $scope );
 
		// Push new user to existing table column
		//
		$scope.users.push( newuser );
		// Reset fields values
		//
		$scope.firstname='';
		$scope.lastname='';
		$scope.address='';
		$scope.email='';
	};		
} ]);
// Controller for Individual User View
userApp.controller("UsersByIdCtrl", [ '$scope','userservice', '$routeParams', function($scope, userservice, $routeParams) {	
	userservice.getUser($routeParams.userId, $scope);	
} ]);




/*
 * function getUserList($scope, $http) {
 * $http.get('http://localhost:8080/angularjs-phone-book/rest/users').
 * success(function(data) { alert(data); $scope.users = data; }); }
 * 
 * function getUserByUserId($scope, $http) {
 * $http.get('http://localhost:8080/angularjs-phone-book/rest/users/userId/1').
 * success(function(data) { $scope.user = data; }); }
 */