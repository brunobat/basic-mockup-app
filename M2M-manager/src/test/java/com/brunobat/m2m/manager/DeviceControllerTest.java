package com.brunobat.m2m.manager;

import com.brunobat.m2m.manager.model.Device;
import com.brunobat.m2m.manager.model.Thermometer;
import org.junit.*;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Bruno Baptista on 15/12/16.
 */
public class DeviceControllerTest {

    @BeforeClass
    public static void initBeforeAllTests() {
        // setup some static content before test class execution
    }

    private DeviceController deviceController;

    @Before
    public void setUpBeforeEachTest() {
        deviceController = new DeviceController(createDevices());
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
        assertEquals(
                "Device: Garage Thermometer reads: 7\n" +
                        "Device: Outside Thermometer reads: 20", deviceController.getDeviceStatus());
    }

    @Test
    public void testGetDeviceStatus_mock() throws Exception {
        //setup
        Device thermometer1 = Mockito.mock(Device.class);
        Thermometer thermometer2 = Mockito.mock(Thermometer.class);

        List<Device> devices = new ArrayList<>();
        devices.add(thermometer1);
        devices.add(thermometer2);

        final DeviceController deviceController = new DeviceController(devices);

        // expectations
        when(thermometer1.getName()).thenReturn("first");
        when(thermometer1.getReading()).thenReturn("-1");

        when(thermometer2.getName()).thenReturn("second");
        when(thermometer2.getReading()).thenReturn("10");

        // execute
        final String deviceStatus = deviceController.getDeviceStatus();

        // validate
        assertEquals(
                "Device: first reads: -1\n" +
                        "Device: second reads: 10\n", deviceStatus);
    }

    @Test(expected = TimeoutException.class)
    public void testGetDeviceStatus_dontHideFailure() throws Exception {
        // setup
        Device thermometer1 = Mockito.mock(Device.class);
        List<Device> devices = new ArrayList<>();
        devices.add(thermometer1);

        final DeviceController deviceController = new DeviceController(devices);
        // expectations
        when(thermometer1.getName()).thenReturn("first");
        when(thermometer1.getReading()).thenThrow(TimeoutException.class);

        // execute
        deviceController.getDeviceStatus();
    }

    private List<Device> createDevices() {
        List<Device> devices = new ArrayList<>();
        devices.add(new Thermometer("Garage Thermometer"));
        devices.add(new Thermometer("Outside Thermometer"));
        return devices;
    }

}