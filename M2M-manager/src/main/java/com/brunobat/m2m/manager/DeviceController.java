package com.brunobat.m2m.manager;

import com.brunobat.m2m.sensors.DevicesFactory;

/**
 * Created by Bruno Baptista on 15/12/16.
 */
public class DeviceController {

    private final ResourceManager manager;

    public DeviceController() {
        manager = new ResourceManager();
        manager.addDevice(DevicesFactory.getDevices());
    }
}
