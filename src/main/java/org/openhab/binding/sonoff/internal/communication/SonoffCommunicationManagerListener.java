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
package org.openhab.binding.sonoff.internal.communication;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.openhab.binding.sonoff.internal.handler.SonoffDeviceListener;
import org.openhab.binding.sonoff.internal.handler.SonoffDeviceState;

/**
 * The {@link SonoffRawMessageListener} passes all received messages from connections to be converted
 *
 * @author David Murton - Initial contribution
 */
@NonNullByDefault
public interface SonoffCommunicationManagerListener {

    // State Operations
    // void addState(String deviceid, SonoffDeviceState state);

    @Nullable
    SonoffDeviceState getState(String deviceid);

    // Device Operations
    @Nullable
    SonoffDeviceListener getListener(String deviceid);

    // Message Operations
    void sendLanMessage(String url, String payload);

    void sendApiMessage(String deviceid);

    void sendWebsocketMessage(String params);
}
