package mobile.driver;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import mobile.config.LocalConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalMobileDriver implements WebDriverProvider {

        public static LocalConfig config = ConfigFactory.create(LocalConfig.class);

        static String url = config.url();
        static String device = config.device();
        static String ver = config.ver();

        public static URL getAppiumServerUrl() {
            try {
                return new URL(url);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        @Nonnull
        @Override
        public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("deviceName", "XSQ4C18B14000291");
            desiredCapabilities.setCapability("version", "8.1.0");
            desiredCapabilities.setCapability("locale", "en");
            desiredCapabilities.setCapability("language", "en");
            desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
            desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
            desiredCapabilities.setCapability("app", getAbsolutePath("src/test/resources/app-alpha-universal-release.apk"));

            return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
        }

        private String getAbsolutePath(String filePath) {
            File file = new File(filePath);
            assertTrue(file.exists(), filePath + " not found");

            return file.getAbsolutePath();
        }
    }