package demo.java9;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TryWithResourcesTest {

    @Test
    void tryWithResourcesJava8Demo() throws IOException {
        InputStream inputStream = new FileInputStream(new File(""));
        try (InputStream inputStreamCopy = inputStream) {
            int available = inputStreamCopy.available();
            System.out.println(available);
        }
    }

    @Test
    void tryWithResourcesJava9Demo() throws IOException {
        InputStream inputStream = new FileInputStream(new File("c:\\Users\\Kanstantsin_Makarau\\soapui-settings.xml"));
        try (inputStream) {
            int available = inputStream.available();
            System.out.println(available);
        }
    }
}
