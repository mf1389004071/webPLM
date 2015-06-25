(function () {
  'use strict';

  angular
    .module('PLMApp')
    .directive('switchExerciseMenuItem', switchExerciseMenuItem);

  switchExerciseMenuItem.$inject = ['exercisesList'];

  function switchExerciseMenuItem(exercisesList) {
    return {
      restrict: 'E',
      templateUrl: '/assets/app/components/switch-exercise-menu-item.directive.html',
      link: function (scope, element, attrs) {
        scope.exercisesList = exercisesList;
        $(document).foundation('offcanvas', 'reflow');
        $(document).foundation('accordion', 'reflow');
      }
    };
  }
})();