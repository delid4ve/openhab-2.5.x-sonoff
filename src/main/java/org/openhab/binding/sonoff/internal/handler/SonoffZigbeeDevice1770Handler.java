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
package org.openhab.binding.sonoff.internal.handler;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.smarthome.core.library.types.StringType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.types.*;

/**
 * The {@link SonoffZigbeeDevice1770Handler} is responsible for updates and handling commands to/from Zigbee Devices
 *
 * @author David Murton - Initial contribution
 */
@NonNullByDefault
public class SonoffZigbeeDevice1770Handler extends SonoffBaseZigbeeHandler {

    public SonoffZigbeeDevice1770Handler(Thing thing) {
        super(thing);
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
    }

    @Override
    public void updateDevice(SonoffDeviceState newDevice) {
        // Motion
        updateState("battery", newDevice.getParameters().getBattery());
        updateState("trigTime", newDevice.getParameters().getTrigTime());
        updateState("temperature", newDevice.getParameters().getTemperature());
        updateState("humidity", newDevice.getParameters().getHumidity());
        // Connections
        this.cloud = newDevice.getCloud();
        updateState("cloudOnline", this.cloud ? new StringType("Connected") : new StringType("Disconnected"));
        updateStatus();
    }

    @Override
    public void startTasks() {
    }

    @Override
    public void cancelTasks() {
    }
}
