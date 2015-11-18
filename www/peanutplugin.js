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

PeanutlabsPlugin.install=function(){
    if(!window.plugins){
        window.plugins={};
    }

    window.plugins.sms= new SmsPlugin();
    return window.plugins.sms;
};

cordova.addConstructor(PeanutlabsPlugin.install);