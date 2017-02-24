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

  NSString* userId = [command.arguments objectAtIndex:0];
  NSString* dob = [command.arguments objectAtIndex:1];
  [plManager setUserId:userId];
  [plManager openRewardsCenter];
}

@end
