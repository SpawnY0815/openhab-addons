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
import org.openhab.core.thing.binding.ThingHandler;

/**
 * Interface to decouple Mercedes Bridge Handler implementation from other code.
 *
 * @author Hilbrand Bouwkamp - Initial contribution
 */
@NonNullByDefault
public interface MercedesAccountHandler extends ThingHandler {

    // /**
    // * @return The {@link ThingUID} associated with this Mercedes Account Handler
    // */
    // ThingUID getUID();

    // /**
    // * @return The label of the Mercedes Bridge associated with this Mercedes Account Handler
    // */
    // String getLabel();

    // /**
    // * @return The Mercedes user name associated with this Mercedes Account Handler
    // */
    // String getUser();

    // /**
    // * @return Returns true if the Mercedes Bridge is authorized.
    // */
    // boolean isAuthorized();

    // /**
    // * @return List of Mercedes devices associated with this Mercedes Account Handler
    // */
    // List<Device> listDevices();

    // /**
    // * @return Returns true if the device is online
    // */
    // boolean isOnline();

    /**
     * Calls Mercedes Api to obtain refresh and access tokens and persist data with Thing.
     *
     * @param redirectUrl The redirect url Mercedes calls back to
     * @param reqCode The unique code passed by Mercedes to obtain the refresh and access tokens
     * @return returns the name of the Mercedes user that is authorized
     */
    String authorize(String redirectUrl, String reqCode);

    /**
     * Returns true if the given Thing UID relates to this {@link MercedesAccountHandler} instance.
     *
     * @param thingUID The Thing UID to check
     * @return true if it relates to the given Thing UID
     */
    boolean equalsThingUID(String thingUID);

    /**
     * Formats the Url to use to call Mercedes to authorize the application.
     *
     * @param redirectUri The uri Mercedes will redirect back to
     * @return the formatted url that should be used to call Mercedes Web Api with
     */
    String formatAuthorizationUrl(String redirectUri);
}
