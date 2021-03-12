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
 * Mercedes authorization problems exception class.
 *
 * @author Hilbrand Bouwkamp - Initial contribution
 */
public class MercedesAuthorizationException extends RuntimeException {

    private static final long serialVersionUID = -1931713564920750911L;

    /**
     * Constructor.
     *
     * @param message Mercedes error message
     */
    public MercedesAuthorizationException(String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param message Mercedes error message
     * @param exception Original cause of this exception
     */
    public MercedesAuthorizationException(String message, Throwable exception) {
        super(message, exception);
    }
}
