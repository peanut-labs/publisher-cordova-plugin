package com.peanutlabs.plsdk;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;

import com.peanutlabs.plsdk.*;


public class PLPluginManager extends CordovaPlugin {
	
	public static final String TAG = "Fucking Apache Cordova";
	
	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
	    super.initialize(cordova, webView);
		Log.v(TAG,"Plugin initialized");
	}
	
	@Override
	public boolean execute(String action, JSONArray jarray, CallbackContext callbackContext) throws JSONException {
		Log.v(TAG, action);
		
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				PeanutLabsManager pm = PeanutLabsManager.getInstance();
				pm.setUserId("bilguun_39-8235-64fce826c6");
				pm.openRewardsCenter(cordova.getActivity());
			}
		});
		
		callbackContext.success();
		return true;
	}
}