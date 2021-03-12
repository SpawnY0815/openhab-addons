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
 * Generic Mercedes exception class.
 *
 * @author Hilbrand Bouwkamp - Initial contribution
 */
public class MercedesException extends RuntimeException {

    private static final long serialVersionUID = -8142837343923954830L;

    /**
     * Constructor.
     *
     * @param message Mercedes error message
     */
    public MercedesException(String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param message Mercedes error message
     * @param cause Original cause of this exception
     */
    public MercedesException(String message, Throwable cause) {
        super(message, cause);
    }
}
