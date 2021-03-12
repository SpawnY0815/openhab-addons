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

/**
 * The {@link MercedesConfiguration} class contains fields mapping thing configuration parameters.
 *
 * @author Chris Pattison - Initial contribution
 */
public class MercedesConfiguration {

    public String vin;
    public String client_id;
    public String client_secret;
    public Boolean scope_fuelstatus;
    public Boolean scope_evstatus;
    public Boolean scope_vehiclelock;
    public Boolean scope_vehiclestatus;
    public Boolean scope_payasyoudrive;
}
