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

import static org.openhab.binding.mercedes.internal.MercedesBindingConstants.*;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jetty.client.HttpClient;
import org.openhab.binding.spotify.internal.handler.MercedesBridgeHandler;
import org.openhab.binding.spotify.internal.handler.MercedesDeviceHandler;
import org.openhab.binding.spotify.internal.handler.MercedesDynamicStateDescriptionProvider;
import org.openhab.core.auth.client.oauth2.OAuthFactory;
import org.openhab.core.io.net.http.HttpClientFactory;
import org.openhab.core.thing.Thing;
import org.openhab.core.thing.ThingTypeUID;
import org.openhab.core.thing.binding.BaseThingHandlerFactory;
import org.openhab.core.thing.binding.ThingHandler;
import org.openhab.core.thing.binding.ThingHandlerFactory;
import org.osgi.service.component.annotations.Component;

/**
 * The {@link MercedesHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Chris Pattison - Initial contribution
 */
@NonNullByDefault
@Component(configurationPid = "binding.mercedes", service = ThingHandlerFactory.class)
public class MercedesHandlerFactory extends BaseThingHandlerFactory {

    private static final Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Set.of(THING_TYPE_VEHICLE);
    private final OAuthFactory oAuthFactory;
    private final HttpClient httpClient;
    private final MercedesAuthService authService;
    private final MercedesDynamicStateDescriptionProvider mercedesDynamicStateDescriptionProvider;

    @Activate
    public MercedesHandlerFactory(@Reference OAuthFactory oAuthFactory,
            @Reference final HttpClientFactory httpClientFactory, @Reference MercedesAuthService authService,
            @Reference MercedesDynamicStateDescriptionProvider mercedesDynamicStateDescriptionProvider) {
        this.oAuthFactory = oAuthFactory;
        this.httpClient = httpClientFactory.getCommonHttpClient();
        this.authService = authService;
        this.mercedesDynamicStateDescriptionProvider = mercedesDynamicStateDescriptionProvider;
    }

    // @Override
    // public boolean supportsThingType(ThingTypeUID thingTypeUID) {
    // return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    // }

    // @Override
    // protected @Nullable ThingHandler createHandler(Thing thing) {
    // ThingTypeUID thingTypeUID = thing.getThingTypeUID();

    // if (THING_TYPE_VEHICLE.equals(thingTypeUID)) {
    // return new MercedesHandler(thing);
    // }

    // return null;
    // }
    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return MercedesBindingConstants.THING_TYPE_PLAYER.equals(thingTypeUID)
                || MercedesBindingConstants.THING_TYPE_DEVICE.equals(thingTypeUID);
    }

    @Override
    protected @Nullable ThingHandler createHandler(Thing thing) {
        final ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (MercedesBindingConstants.THING_TYPE_PLAYER.equals(thingTypeUID)) {
            final MercedesBridgeHandler handler = new MercedesBridgeHandler((Bridge) thing, oAuthFactory, httpClient,
                    mercedesDynamicStateDescriptionProvider);
            authService.addMercedesAccountHandler(handler);
            return handler;
        }
        if (MercedesBindingConstants.THING_TYPE_DEVICE.equals(thingTypeUID)) {
            return new MercedesDeviceHandler(thing);
        }
        return null;
    }

    @Override
    protected synchronized void removeHandler(ThingHandler thingHandler) {
        if (thingHandler instanceof MercedesBridgeHandler) {
            authService.removeMercedesAccountHandler((MercedesBridgeHandler) thingHandler);
        }
    }
}
