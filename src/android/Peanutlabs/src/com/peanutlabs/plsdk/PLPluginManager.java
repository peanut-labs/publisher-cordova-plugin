package com.peanutlabs.plsdk;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;

import com.peanutlabs.plsdk.*;


public class PLPluginManager extends CordovaPlugin {
	
	public static final String TAG = "Peanutlabs";
	public static final String ACTION_OPEN_WITH_USERID = "openRewardsCenterWithUserId";
	public static final String ACTION_OPEN_WITH_APPID = "openRewardsCenterWithAppId";
	
	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
	    super.initialize(cordova, webView);
		Log.v(TAG,"Plugin initialized");
	}
	
	@Override
	public boolean execute(String action, JSONArray jarray, CallbackContext callbackContext) {
		Log.v(TAG, action);
		
		try {
			
			if(ACTION_OPEN_WITH_USERID.equals(action)) {
				openRewardsCenterWithUserId(jarray);
			} else if(ACTION_OPEN_WITH_APPID.equals(action)) {
				openRewardsCenterWithAppId(jarray);
			}
			
			callbackContext.success();
		} catch (PLException e) {
			callbackContext.error(e.getMessage());
		} catch (JSONException e) {
			callbackContext.error(e.getMessage());
		}
		
		return true;
	}
	
	private void openRewardsCenterWithUserId(JSONArray jarray) throws PLException, JSONException {
		JSONObject obj = jarray.getJSONObject(0);
		
		final String user_id = obj.getString("user_id");
		final String dob = obj.getString("dob");
		final String gender = obj.getString("gender");
		final JSONArray custom_parameters = obj.optJSONArray("custom_parameters");
		
		if(user_id == "" || user_id.equals(null) || user_id == "null") {
			throw new PLException("User generated full user id not found");
		}
		
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					PeanutLabsManager pm = PeanutLabsManager.getInstance();
					pm.setUserId(user_id);
					pm.setDob(dob);
					pm.setGender(gender);

					if(custom_parameters != null) {
						for (int i = 0; i < custom_parameters.length(); i++) {
							JSONObject row = custom_parameters.getJSONObject(i);

							pm.addCustomParameters(row.getString("key"), row.getString("value"));
						}
					}
				
					pm.openRewardsCenter(cordova.getActivity());
					
				} catch (JSONException e) {
				}
			}
		});
	}
	
	private void openRewardsCenterWithAppId(JSONArray jarray) throws PLException, JSONException {
		JSONObject obj = jarray.getJSONObject(0);
		final int app_id = obj.getInt("app_id");
		final String app_key = obj.getString("app_key");
		final String end_user_id = obj.getString("end_user_id");
		final String dob = obj.getString("dob");
		final String gender = obj.getString("gender");
		final JSONArray custom_parameters = obj.optJSONArray("custom_parameters");
		
		if(app_id == -1) {
			throw new PLException("app_id not found");
		}
		
		if(app_key == "" || app_key.equals(null) || app_key == "null") {
			throw new PLException("app_key not found");
		}
		
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					PeanutLabsManager pm = PeanutLabsManager.getInstance();
					pm.setApplicationId(app_id);
					pm.setApplicationKey(app_key);
					pm.setEndUserId(end_user_id);
					pm.setDob(dob);
					pm.setGender(gender);

					if(custom_parameters != null) {
						for (int i = 0; i < custom_parameters.length(); i++) {
							JSONObject row = custom_parameters.getJSONObject(i);

							pm.addCustomParameters(row.getString("key"), row.getString("value"));
						}
					}

					pm.openRewardsCenter(cordova.getActivity());
					
				} catch (JSONException e) {
				}
			}
		});
	}
}