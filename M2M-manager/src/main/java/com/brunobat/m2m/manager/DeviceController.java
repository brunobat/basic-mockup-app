package com.brunobat.m2m.manager;


import com.brunobat.m2m.manager.model.Device;
import com.brunobat.m2m.manager.model.Thermometer;

import java.util.ArrayList;
import java.util.List;

/**
 * 1st Example. All in one class. Device storage, management and application service all in the came class.
 * Created by Bruno Baptista on 15/12/16.
 */
public class DeviceController {

    private final List<Device> devices;

    public DeviceController() {
        devices = new ArrayList<>();
        devices.add(new Thermometer("Garage Thermometer"));
        devices.add(new Thermometer("Outside Thermometer"));
    }

    public void printDeviceStatus() {
        for (Device device : devices) {
            System.out.print("Device: " + device.getName() + " reads: " + device.getReading());
        }
    }
}
