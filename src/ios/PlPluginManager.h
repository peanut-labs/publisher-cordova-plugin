//
//  PlPluginManager.h
//
//  Created by Peanut Labs Inc on 1/10/15.
//  Copyright (c) 2017 PeanutLabs. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <Cordova/CDV.h>

@interface PlPluginManager : CDVPlugin

// Exec API
- (void)openRewardCenterWithUserId:(CDVInvokedUrlCommand*)command;
- (void)openRewardCenterWithAppId:(CDVInvokedUrlCommand*)command;

@end
