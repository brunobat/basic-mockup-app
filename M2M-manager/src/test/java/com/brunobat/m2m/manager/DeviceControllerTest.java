package com.brunobat.m2m.manager;

import org.junit.*;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

/**
 * Created by Bruno Baptista on 15/12/16.
 */
public class DeviceControllerTest {

    private static final Logger LOGGER = Logger.getLogger(DeviceControllerTest.class.getName());

    @BeforeClass
    public static void initBeforeAllTests() {
        // setup some static content before test class execution
    }

    private DeviceController deviceController;

    @Before
    public void setUpBeforeEachTest() {
        deviceController = new DeviceController();
    }

    @Test
    public void testGetDeviceNames() {

        final List<String> deviceNames = deviceController.getDeviceNames();

        Assert.assertNotNull(deviceNames);
        Assert.assertEquals(2, deviceNames.size());
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
        final String deviceStatus = deviceController.getDeviceStatus();
        LOGGER.info("Returned Status: \n" + deviceStatus);

        assertEquals(
                "Device: Garage Thermometer reads: 7\n" +
                        "Device: Outside Thermometer reads: 20", deviceStatus);
    }

}