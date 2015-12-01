# publisher-cordova-plugin

Peanut Labs connects your users with thousands of paid online surveys from big brands and market researchers. This SDK allows you to integrate our Reward Center within your Cordova application for Android.

This Cordova plugin only supports Android at the moment, we do plan on supporting iPhone in the near future. If you run into any issues please use Github issues to report.

#The Reward Center

The Reward Center lists surveys and offers best suited for each of your members. It is highly customizable and positively engaging.

You get paid whenever your members complete a listing, and get to reward them back in the virtual currency of your choice.

All of this and much more is configured and monitored through our Publisher Dashboard. To learn more and get access to our full set of tools, get in touch with us at publisher.integration@peanutlabs.com

#Integration

Check out <a href="http://peanut-labs.github.io/publisher-doc/" target="_blank">our integration guide</a> for step by step instructions on getting up and running with our Reward Center within your Android application.

#Cordova Usage

* To add plugin
```
cordova plugin add https://github.com/peanut-labs/publisher-cordova-plugin.git
```

* To remove plugin
```
cordova plugin remove PeanutlabsLib
```

#Open rewards Center

* Include following line in your js file where you want to use our plugin
```javascript
<script type="text/javascript" src="plugins/PeanutlabsLib/www/peanutplugin.js"></script>
```

* Call following methods with appropriate parameters to open rewards center
```javascript
PeanutlabsPlugin.openRewardsCenterWithAppId(YOUR_APP_ID, YOUR_APP_KEY, USER_ID, YOUR_DOB, GENDER, CUSTOM_PARAM, success, error);

```

```javascript
PeanutlabsPlugin.openRewardsCenterWithAppId(YOUR_GENERATED_USER_ID, YOUR_DOB, GENDER, CUSTOM_PARAM, success, error);

```

* See example project included github for more details