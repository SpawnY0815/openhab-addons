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
package org.openhab.binding.mercedes.internal.api.exception;

/**
 * Mercedes exception indicating the access token has expired.
 *
 * @author Hilbrand Bouwkamp - Initial contribution
 */
public class MercedesTokenExpiredException extends MercedesAuthorizationException {

    private static final long serialVersionUID = 709275673779738436L;

    /**
     * Constructor
     *
     * @param message Mercedes error message
     */
    public MercedesTokenExpiredException(String message) {
        super(message);
    }
}
