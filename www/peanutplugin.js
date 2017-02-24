var exec = require('cordova/exec');

var PeanutlabsPlugin = {
	
	// custom param will expect following json array or null
	// [
	// 	{key: "param_key_1", value: "param_value_1"},
	// 	{key: "param_key_2", value: "param_value_2"},
	// ]
	openRewardsCenterWithUserId: function(userId, dob, gender, custom_param, successCallback, failureCallback) {
		var options = [];
		
		options.push({
			"user_id": userId,
			"dob": dob,
			"gender": gender,
			"custom_parameters": custom_param
		});
		
		cordova.exec(successCallback, failureCallback, 'PeanutlabsPlugin', 'openRewardsCenterWithUserId', options);
	},
	
	// custom param will expect following json array or null
	// [
	// 	{key: "param_key_1", value: "param_value_1"},
	// 	{key: "param_key_2", value: "param_value_2"},
	// ]
	openRewardsCenterWithAppId: function(appId, appKey, endUserId, dob, gender, custom_param, successCallback, failureCallback) {
		var options = [];
		
		options.push({
			"app_id": appId,
			"app_key": appKey,
			"end_user_id": endUserId,
			"dob": dob,
			"gender": gender,
			"custom_parameters": custom_param
		});
		
		cordova.exec(successCallback, failureCallback, 'PeanutlabsPlugin', 'openRewardsCenterWithAppId', options);
	}
};

module.exports = PeanutlabsPlugin;
