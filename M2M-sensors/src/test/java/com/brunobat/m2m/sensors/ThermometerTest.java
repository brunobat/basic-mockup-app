package com.brunobat.m2m.sensors;

import com.brunobat.m2m.api.Device;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.isA;

/**
 * Created by Bruno Baptista on 15/12/16.
 */
public class ThermometerTest {

    @Test
    public void testGetName() throws Exception {
        // setup
        final String name = "MyThermometer";
        // execution
        final Thermometer thermometer = new Thermometer(name);
        // validation
        Assert.assertEquals(name, thermometer.getName());
    }

    @Test()
    public void testGetName_null() throws Exception {
        // setup
        final String name = null;
        // execution
        final Thermometer thermometer = new Thermometer(name);
        // validation
        Assert.assertNull(thermometer.getName());
    }

    @Test
    public void testDevice() throws Exception {

        final Thermometer thermometer = new Thermometer("MyThermometer");

        Assert.assertThat(thermometer, isA(Device.class));
    }

    @Test
    public void getReading() throws Exception {

        final Thermometer thermometer = new Thermometer("MyThermometer");
        final String reading = thermometer.getReading();

        Assert.assertNotNull(reading);
        Assert.assertNotEquals("", reading);
        Assert.assertTrue(Integer.parseInt(reading) > -6);
        Assert.assertTrue(Integer.parseInt(reading) < 46);
    }

}