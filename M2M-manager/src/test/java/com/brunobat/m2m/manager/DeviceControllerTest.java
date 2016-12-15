package com.brunobat.m2m.manager;

import org.junit.*;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Bruno Baptista on 15/12/16.
 */
public class DeviceControllerTest {

    @BeforeClass
    public static void init() {
        // setup some static content before test class execution
    }

    private DeviceController deviceController;

    @Before
    public void setUp() {
        deviceController = new DeviceController();
    }

    @Test
    public void testGetDeviceNames() {

        final List<String> deviceNames = deviceController.getDeviceNames();

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
//
//    @Test
//    public void testGetDeviceStatus_spy() throws Exception {
//        //setup
//        ResourceManager resourceManager = Mockito.mock(ResourceManager.class);
//        deviceController.setManager(resourceManager);
//
//        // expectations
//        Map<String, String> expectations = new HashMap<>();
//        expectations.put("first", "-1");
//        expectations.put("second", "10");
//        when(resourceManager.getReadingFromAllDevices()).thenReturn(expectations);
//
//        // execute
//        final String deviceStatus = deviceController.getDeviceStatus();
//
//        // validate
//        assertEquals(
//                "Device: first reads: -1\n" +
//                        "Device: second reads: 10\n", deviceStatus);
//    }



}