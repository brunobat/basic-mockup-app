package com.brunobat.m2m.manager;

import com.brunobat.m2m.api.Device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bruno Baptista on 15/12/16.
 */
public class ResourceManager {

    private final Map<String, Device> devices;

    public ResourceManager() {
        this.devices = new HashMap<>();
    }

    public void addDevice(final Device device) {
        devices.put(device.getName(), device);
    }

    public void addDevice(final List<Device> devices) {
        for (Device device : devices) {
            this.devices.put(device.getName(), device);
        }
    }

    public String getReading(final String deviceName) {
        return devices.get(deviceName).getReading();
    }

    public Map<String, String>  getReadingFromAllDevices() {
        final Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, Device> entry : devices.entrySet()) {
            result.put(entry.getKey(), entry.getValue().getReading());
        }
        return result;
    }

}

