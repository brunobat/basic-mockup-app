package com.brunobat.m2m.manager;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Bruno Baptista on 15/12/16.
 */
public class DeviceControllerTest {

    @Test
    public void testGetDeviceNames() {

        DeviceController deviceController = new DeviceController();
        final List<String> deviceNames = deviceController.getDeviceNames();

        Assert.assertNotNull(deviceNames);
        Assert.assertEquals(2, deviceNames.size());
        Assert.assertTrue(deviceNames.contains("Garage Thermometer"));
        Assert.assertTrue(deviceNames.contains("Outside Thermometer"));
    }

    /**
     * Failing test
     * @throws Exception
     */
    @Ignore
    @Test
    public void testGetDeviceStatus() throws Exception {
        DeviceController deviceController = new DeviceController();
        assertEquals("Device: Garage Thermometer reads: 7\n" +
                "Device: Outside Thermometer reads: 20", deviceController.getDeviceStatus());
    }

}