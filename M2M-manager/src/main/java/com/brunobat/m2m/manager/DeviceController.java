package com.brunobat.m2m.manager;


import com.brunobat.m2m.manager.model.Device;

import java.util.ArrayList;
import java.util.List;

/**
 * 1st Example. All in one class. Device storage, management and application service all in the came class.
 * Created by Bruno Baptista on 15/12/16.
 */
public class DeviceController {

    private final List<Device> devices;

    public DeviceController(final List<Device> devices) {
        this.devices = devices;
    }

    public List<String> getDeviceNames() {
        final List<String> deviceNames = new ArrayList<>();
        for (Device device : devices) {
            deviceNames.add(device.getName());
        }
        return deviceNames;
    }

    public void printDeviceStatus() {
        System.out.print(getDeviceStatus());
    }

    protected String getDeviceStatus() {
        final StringBuilder sb = new StringBuilder();
        for (Device device : devices) {
            sb.append("Device: ")
                    .append(device.getName())
                    .append(" reads: ")
                    .append(device.getReading())
                    .append("\n");
        }
        return sb.toString();
    }

}
