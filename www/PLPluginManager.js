var argscheck = require('cordova/argscheck');
var	exec = require('cordova/exec');

var peanutlabsExport = {};

peanutlabsExport.openRewardsCenter = function(options, successCallback, failureCallback) {
	
	if(typeof options === 'undefined' || options == null) options = {};
	
	cordova.exec(successCallback, failureCallback, 'PLPluginManager', 'action', [options]);
};

module.export = peanutlabsExport;