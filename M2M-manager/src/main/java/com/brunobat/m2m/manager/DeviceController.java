package com.brunobat.m2m.manager;

import com.brunobat.m2m.sensors.DevicesFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Bruno Baptista on 15/12/16.
 */
public class DeviceController {

    private ResourceManager manager;

    public DeviceController() {
        manager = new ResourceManager();
        manager.addDevice(DevicesFactory.getDevices());
    }

    public void printDeviceStatus(final String deviceStatus) {
        System.out.print(deviceStatus);
    }

    protected String getDeviceStatus() {
        final StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : manager.getReadingFromAllDevices().entrySet()) {
            sb.append("Device: ")
                    .append(entry.getKey())
                    .append(" reads: ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return sb.toString();
    }

    protected String getDeviceStatus(final String deviceName) {
        final StringBuilder sb = new StringBuilder();
        final String reading = manager.getReading(deviceName);
        if (reading == null) {
            return "";
        }
        sb.append("Device: ")
                .append(deviceName)
                .append(" reads: ")
                .append(reading)
                .append("\n");
        return sb.toString();
    }

    public List<String> getDeviceNames() {
        return new ArrayList<>(manager.getAllDeviceNames());
    }

    public ResourceManager getManager() {
        return manager;
    }

    public void setManager(ResourceManager manager) {
        this.manager = manager;
    }
}
