var userManagerModule = angular.module('userManagerApp', ['ngAnimate']);

userManagerModule.controller('userManagerController', function ($scope,$http) {
 
 var urlBase="http://localhost:8080/angularjs-phone-book";
 
 $scope.toggle=true;
 $scope.selection = [];
 $scope.statuses=['ACTIVE','COMPLETED'];
 $scope.priorities=['HIGH','LOW','MEDIUM'];
 $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
 
 //get all users and display initially
 $http.get(urlBase+'/users').
     success(function(data) {
         $scope.users = data;
         for(var i=0;i<$scope.users.length;i++){
             if($scope.users[i].userStatus=='COMPLETED'){
              $scope.selection.push($scope.users[i].userId);
         }
         }
    });
 
 //add a new user
 $scope.addUser = function addUser() {
  if($scope.userName=="" || $scope.userDesc=="" || $scope.userPriority == "" || $scope.userStatus == ""){
   alert("Insufficient Data! Please provide values for user name, description, priortiy and status");
  }
  else{
   $http.post(urlBase + '/users/insert/' +$scope.userName+'/'+$scope.userDesc+'/'+$scope.userPriority+'/'+$scope.userStatus).
    success(function(data) {
    alert("User added");
    $scope.users = data; 
    $scope.userName="";
    $scope.userDesc="";
    $scope.userPriority="";
    $scope.userStatus="";
    $scope.toggle='!toggle';    
      });
  }
 };
  
 // toggle selection for a given user by user id
   $scope.toggleSelection = function toggleSelection(userId) {
     var idx = $scope.selection.indexOf(userId);

     // is currently selected
     if (idx > -1) {
       $http.post(urlBase + '/users/' +userId+'/ACTIVE').
    success(function(data) {
    alert("User unmarked");
    $scope.users = data;         
      });
       $scope.selection.splice(idx, 1);
     }

     // is newly selected
     else {
       $http.post(urlBase + '/users/' +userId+'/COMPLETED').
    success(function(data) {
    alert("User marked completed");
    $scope.users = data;
      });
       $scope.selection.push(userId);
     }
   };
   
 
 // Archive Completed Users
   $scope.archiveUsers = function archiveUsers() {
    $http.post(urlBase + '/users/archive/' + $scope.selection).
    success(function(data) {
     $scope.users = data;
         alert("Successfully Archived");
      });
   };
 
});

//Angularjs Directive for confirm dialog box
userManagerModule.directive('ngConfirmClick', [
 function(){
         return {
             link: function (scope, element, attr) {
                 var msg = attr.ngConfirmClick || "Are you sure?";
                 var clickAction = attr.confirmedClick;
                 element.bind('click',function (event) {
                     if ( window.confirm(msg) ) {
                         scope.$eval(clickAction);
                     }
                 });
             }
         };
 }]);