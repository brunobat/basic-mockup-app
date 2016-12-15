package com.brunobat.m2m.sensors;

import com.brunobat.m2m.api.Device;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno Baptista on 15/12/16.
 */
public class DevicesFactory {
    public static List<Device> getDevices() {
        List<Device> devices = new ArrayList<>();
        devices.add(new Thermometer("Garage Thermometer"));
        devices.add(new Thermometer("Outside Thermometer"));
        return devices;
    }
}
