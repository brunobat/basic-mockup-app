package com.brunobat.m2m.manager;

import com.brunobat.m2m.sensors.DevicesFactory;

import java.util.Map;

/**
 * Created by Bruno Baptista on 15/12/16.
 */
public class DeviceController {

    private final ResourceManager manager;

    public DeviceController() {
        manager = new ResourceManager();
        manager.addDevice(DevicesFactory.getDevices());
    }

    public void printDeviceStatus() {
        for (Map.Entry<String, String> entry : manager.getReadingFromAllDevices().entrySet()) {
            System.out.print("Device: " + entry.getKey() + " reads: " + entry.getValue());
        }
    }
}
