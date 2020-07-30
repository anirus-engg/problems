package com.ags.process;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ConnectionTest {

    public ConnectionTest() throws IOException, URISyntaxException {
        URL res = getClass().getClassLoader().getResource("connected.txt");
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();

        LoadFile loadFile = new LoadFile();
        loadFile.processFile(absolutePath);
    }

    @Test
    public void areConnectedTest1() {
        String expected = "no";
        Connection connection = new Connection();
        Assert.assertEquals(expected, connection.areConnected("Boston", "Denver"));
    }

    @Test
    public void areConnectedTest2() {
        String expected = "yes";
        Connection connection = new Connection();
        Assert.assertEquals(expected, connection.areConnected("Boston", "Hartford"));
    }

    @Test
    public void areConnectedTest3() {
        String expected = "yes";
        Connection connection = new Connection();
        Assert.assertEquals(expected, connection.areConnected("Boston", "Tampa"));
    }

    @Test
    public void areConnectedTest4() {
        String expected = "no";
        Connection connection = new Connection();
        Assert.assertEquals(expected, connection.areConnected("New York", "Chicago"));
    }

    @Test
    public void areConnectedTest5() {
        String expected = "yes";
        Connection connection = new Connection();
        Assert.assertEquals(expected, connection.areConnected("Los Angeles", "San Diego"));
    }
}
