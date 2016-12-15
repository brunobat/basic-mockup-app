package com.brunobat.m2m.manager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Bruno Baptista on 15/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class DeviceControllerRunnerTest {

    private DeviceController deviceController;

    @Mock
    private ResourceManager resourceManager;

    @Before
    public void setUp() {
        deviceController = new DeviceController();
        deviceController.setManager(resourceManager);
    }


    @Test
    public void testGetDeviceStatus_mock() throws Exception {

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

}