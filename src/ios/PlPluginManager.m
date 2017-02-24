//
//  PlPluginManager.h
//
//  Created by Peanut Labs Inc on 1/10/15.
//  Copyright (c) 2017 PeanutLabs. All rights reserved.
//

#import "PlPluginManager.h"
#import "PeanutLabsManager.h"

@implementation PlPluginManager

- (void)openRewardCenterWithUserId:(CDVInvokedUrlCommand*)command {
    PeanutLabsManager *plManager = [PeanutLabsManager getInstance];
    NSDictionary* data = [command.arguments objectAtIndex:0];

    NSString* userId = data[@"user_id"];
    if ([userId length] == 0){
        [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Missing user_id argument"] callbackId:command.callbackId];
        return;
    } else {
        [plManager setUserId:userId];
    }

    NSString* dob = data[@"dob"];
    if ([dob length] > 0){
        [plManager setDob:dob];
    }

    NSString* gender = data[@"gender"];
    if ([gender length] > 0){
        [plManager setSex:gender];
    }

    NSArray* customParameters = data[@"custom_parameters"];
    if (![customParameters isEqual:[NSNull null]]){
        for (id param in customParameters){
            [plManager addCustomParameter:param[@"key"] value:param[@"value"]];
        }
    }

    [plManager openRewardsCenter];
    [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_OK] callbackId:command.callbackId];
}

- (void)openRewardCenterWithAppId:(CDVInvokedUrlCommand*)command {
    PeanutLabsManager *plManager = [PeanutLabsManager getInstance];
    NSDictionary* data = [command.arguments objectAtIndex:0];

    NSString* appId = data[@"app_id"];
    if ([appId length] == 0){
        [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Missing app_id argument"] callbackId:command.callbackId];
        return;
    } else {
        [plManager setAppId:(int)appId];
    }

    NSString* appKey = data[@"app_key"];
    if ([appKey length] == 0){
        [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Missing app_key argument"] callbackId:command.callbackId];
        return;
    } else {
        [plManager setAppKey:appKey];
    }

    NSString* endUserId = data[@"end_user_id"];
    if ([endUserId length] > 0){
        [plManager setEndUserId:endUserId];
    }

    NSString* dob = data[@"dob"];
    if ([dob length] > 0){
        [plManager setDob:dob];
    }

    NSString* gender = data[@"gender"];
    if ([gender length] > 0){
        [plManager setSex:gender];
    }

    NSArray* customParameters = data[@"custom_parameters"];
    if (![customParameters isEqual:[NSNull null]]){
        for (id param in customParameters){
            [plManager addCustomParameter:param[@"key"] value:param[@"value"]];
        }
    }

    [plManager openRewardsCenter];
    [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_OK] callbackId:command.callbackId];
}

@end
