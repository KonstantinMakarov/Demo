package demo.java9;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TryWithResourcesTest {

    @Test
    public void tryWithResourcesJava8Demo() throws IOException {
        try (InputStream inputStreamCopy = new FileInputStream(new File("c:\\Users\\Kanstantsin_Makarau\\soapui-settings.xml"))) {
            int available = inputStreamCopy.available();
            System.out.println(available);
        }
        try (InputStream inputStreamCopy = new FileInputStream(new File("c:\\Users\\Kanstantsin_Makarau\\soapui-settings.xml"))) {
            int available = inputStreamCopy.available();
            System.out.println(available);
        }
        try (InputStream inputStreamCopy = new FileInputStream(new File("c:\\Users\\Kanstantsin_Makarau\\soapui-settings.xml"))) {
            int available = inputStreamCopy.available();
            System.out.println(available);
        }
    }

    @Test
    public void tryWithResourcesJava9Demo() throws IOException {
        InputStream inputStream = new FileInputStream(new File("c:\\Users\\Kanstantsin_Makarau\\soapui-settings.xml"));
        try (inputStream) {
            int available = inputStream.available();
            System.out.println(available);
        }
        try (inputStream) {
            int available = inputStream.available();
            System.out.println(available);
        }
        try (inputStream) {
            int available = inputStream.available();
            System.out.println(available);
        }
    }
}
