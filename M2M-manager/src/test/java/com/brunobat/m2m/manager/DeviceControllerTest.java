package com.brunobat.m2m.manager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Bruno Baptista on 15/12/16.
 */
public class DeviceControllerTest {

    private static final Logger LOGGER = Logger.getLogger(DeviceControllerTest.class.getName());

    private DeviceController deviceController;

    @Before
    public void setUp() {
        deviceController = new DeviceController();
    }

    @Test
    public void testGetDeviceNames() {

        final List<String> deviceNames = deviceController.getDeviceNames();

        LOGGER.info("Device Names: " + deviceNames);

        Assert.assertNotNull(deviceNames);
        assertEquals(2, deviceNames.size());
        Assert.assertTrue(deviceNames.contains("Garage Thermometer"));
        Assert.assertTrue(deviceNames.contains("Outside Thermometer"));
    }

    /**
     * Failing test
     *
     * @throws Exception
     */
    @Ignore
    @Test
    public void testGetDeviceStatus() throws Exception {
        assertEquals(
                "Device: Garage Thermometer reads: 7\n" +
                        "Device: Outside Thermometer reads: 20", deviceController.getDeviceStatus());
    }

    @Test
    public void testGetDeviceStatus_mock() throws Exception {
        //setup
        ResourceManager resourceManager = Mockito.mock(ResourceManager.class);
        deviceController.setManager(resourceManager);

        // expectations
        Map<String, String> expectations = new HashMap<>();
        expectations.put("first", "-1");
        expectations.put("second", "10");
        when(resourceManager.getReadingFromAllDevices()).thenReturn(expectations);

        // execute
        final String deviceStatus = deviceController.getDeviceStatus();

        // validate
        assertEquals(
                "Device: first reads: -1\n" +
                        "Device: second reads: 10\n", deviceStatus);
    }

    @Test
    public void testGetDeviceStatus_withArguments() throws Exception {
        //setup
        ResourceManager resourceManager = Mockito.mock(ResourceManager.class);
        deviceController.setManager(resourceManager);

        // expectations
        when(resourceManager.getReading("first")).thenReturn("-1");

        // execute
        final String deviceStatus1 = deviceController.getDeviceStatus("first");
        // validate
        assertEquals("Device: first reads: -1\n", deviceStatus1);

        // execute
        final String deviceStatus2 = deviceController.getDeviceStatus("second");
        // validate
        assertEquals("", deviceStatus2);
    }

    @Test
    public void testGetDeviceStatus_withArguments_anyString() throws Exception {
        //setup
        ResourceManager resourceManager = Mockito.mock(ResourceManager.class);
        deviceController.setManager(resourceManager);

        // expectations
        when(resourceManager.getReading(anyString())).thenReturn("10");
        // execute
        final String deviceStatus = deviceController.getDeviceStatus("something");
        // validate
        assertEquals("Device: something reads: 10\n", deviceStatus);
    }

    @Test
    public void testGetDeviceStatus_withArguments_verify() throws Exception {
        //setup
        ResourceManager resourceManager = Mockito.mock(ResourceManager.class);
        deviceController.setManager(resourceManager);

        // execute
        final String deviceStatus = deviceController.getDeviceStatus("something");

        // validate
        verify(resourceManager, times(1)).getReading("something");
        verify(resourceManager, atMost(2)).getReading("something");

        verify(resourceManager, times(0)).getReading("notExpected");
        verify(resourceManager, never()).getReading("notExpected");

        verify(resourceManager, atLeastOnce()).getReading(anyString());
    }

}