package com.joaoibarra.yat.feature;

import com.joaoibarra.yat.feature.base.Constants;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class APITeamWorkAvailabilityTest {
    @Test
    public void testAvailability() throws Exception {
        URLConnection connection = new URL(Constants.API_URL).openConnection();
        InputStream inputStream = connection.getInputStream();

        StringBuffer buffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                buffer.append(line);
            }
        }
        assert buffer.length() > 0;
    }
}