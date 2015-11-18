var exec = require('cordova/exec');


// var PeanutlabsPlugin = function() {};
//
// PeanutlabsPlugin.prototype.openRewardsCenter = function(options, successCallback, failureCallback) {
// 	return cordova.exec(successCallback, failureCallback, 'PLPluginManager', 'action', [options]);
// };

var PeanutlabsPlugin = {
	openRewardsCenter: function(options, successCallback, failureCallback) {
		cordova.exec(successCallback, failureCallback, 'PLPluginManager', 'action', [options]);
	}
};

module.exports = PeanutlabsPlugin;