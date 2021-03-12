/**
 * Copyright (c) 2010-2021 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.mercedes.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.thing.ThingTypeUID;

/**
 * The {@link MercedesBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Chris Pattison - Initial contribution
 */
@NonNullByDefault
public class MercedesBindingConstants {

    private static final String BINDING_ID = "mercedes";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_VEHICLE = new ThingTypeUID(BINDING_ID, "vehicle");

    // List of all Channel ids
    public static final String CHANNEL_ACCESSTOKEN = "accessToken";
    public static final String CHANNEL_REFRESHTOKEN = "refreshToken";

    public static final String CHANNEL_RANGELIQUID = "rangeliquid";
    public static final String CHANNEL_TANKLEVELPERCENT = "tanklevelpercent";
    public static final String CHANNEL_DECKLIDSTATUS = "decklidstatus";
    public static final String CHANNEL_DOORSTATUSFRONTLEFT = "doorstatusfrontleft";
    public static final String CHANNEL_DOORSTATUSFRONTRIGHT = "doorstatusfrontright";
    public static final String CHANNEL_DOORSTATUSREARLEFT = "doorstatusrearleft";
    public static final String CHANNEL_DOORSTATUSREARRIGHT = "doorstatusrearright";
    public static final String CHANNEL_INTERIORLIGHTSFRONT = "interiorlightsfront";
    public static final String CHANNEL_INTERIORLIGHTSREAR = "interiorlightsrear";
    public static final String CHANNEL_LIGHTSWITCHPOSITION = "lightswitchposition";
    public static final String CHANNEL_READINGLAMPFRONTLEFT = "readinglampfrontleft";
    public static final String CHANNEL_READINGLAMPFRONTRIGHT = "readinglampfrontright";
    public static final String CHANNEL_ROOFTOPSTATUS = "rooftopstatus";
    public static final String CHANNEL_SUNROOFSTATUS = "sunroofstatus";
    public static final String CHANNEL_WINDOWSTATUSFRONTLEFT = "windowstatusfrontleft";
    public static final String CHANNEL_WINDOWSTATUSFRONTRIGHT = "windowstatusfrontright";
    public static final String CHANNEL_WINDOWSTATUSREARLEFT = "windowstatusrearleft";
    public static final String CHANNEL_WINDOWSTATUSREARRIGHT = "windowstatusrearright";
    public static final String CHANNEL_DOORLOCKSTATUSDECKLID = "doorlockstatusdecklid";
    public static final String CHANNEL_DOORLOCKSTATUSVEHICLE = "doorlockstatusvehicle";
    public static final String CHANNEL_DOORLOCKSTATUSGAS = "doorlockstatusgas";
    public static final String CHANNEL_POSITIONHEADING = "positionheading";
    public static final String CHANNEL_SOC = "soc";
    public static final String CHANNEL_RANGEELECTRIC = "rangeelectric";
    public static final String CHANNEL_ODO = "odo";

    // List of Mercedes services related urls, information
    public static final String MERCEDES_AUTH_URL = "https://id.mercedes-benz.com/as/authorization.oauth2";
    public static final String MERCEDES_TOKEN_URL = "https://id.mercedes-benz.com/as/token.oauth2";
    public static final String MERCEDES_API_URL = "https://api.mercedes-benz.com/vehicledata/v2/vehicles/";

    // Authorization related Servlet and resources aliases.
    public static final String MERCEDES_ALIAS = "/connectmercedes";

    // Mercedes scopes needed by this binding to work.
    public static final String MERCEDES_SCOPE_FUELSTATUS = "mb:vehicle:mbdata:fuelstatus ";
    public static final String MERCEDES_SCOPE_EVSTATUS = "mb:vehicle:mbdata:evstatus ";
    public static final String MERCEDES_SCOPE_VEHICLELOCK = "mb:vehicle:mbdata:vehiclelock ";
    public static final String MERCEDES_SCOPE_VEHICLESTATUS = "mb:vehicle:mbdata:vehiclestatus ";
    public static final String MERCEDES_SCOPE_PAYASYOUDRIVE = "mb:vehicle:mbdata:payasyoudrive ";

    public static final String MERCEDES_SCOPE_REFRESHTOKEN = "offline_access";
    // List of Bridge configuration params
    // public static final String CONFIGURATION_CLIENT_ID = "clientId";

    // List of Bridge/Thing properties
    // public static final String PROPERTY_MERCEDES_USER = "user";
    // public static final String PROPERTY_MERCEDES_DEVICE_NAME = "deviceName";
}
