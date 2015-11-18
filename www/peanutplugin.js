// var argscheck = require('cordova/argscheck');
// var	exec = require('cordova/exec');
//
// module.exports = {
// 	openRewardsCenter: function(options, successCallback, failureCallback) {
// 		cordova.exec(successCallback, failureCallback, 'PLPluginManager', 'action', [options]);
// 	}
// };


var PeanutlabsPlugin = function() {};

PeanutlabsPlugin.prototype.openRewardsCenter = function(options, successCallback, failureCallback) {
	return cordova.exec(successCallback, failureCallback, 'PLPluginManager', 'action', [options]);
};

module.exports = new PeanutlabsPlugin();