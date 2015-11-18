package com.peanutlabs.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.peanutlabs.plsdk.*;

public class PLPluginManager extends CordovaPlugin {
	
	
	@override
	public boolean execute(String action, JSONArray jarray, CallbackContext callbackContext) throws JSONException {
		PeanutLabsManager pm = PeanutLabsManager.getInstance();
		pm.setUserId("bilguun_39-8235-64fce826c6");
		pm.openRewardsCenter(this.cordova.getActivity());
		
		callbackContext.success();
		return true;
	}
}