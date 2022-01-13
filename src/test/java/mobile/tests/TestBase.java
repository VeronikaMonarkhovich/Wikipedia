package mobile.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import mobile.configs.HostConfig;
import mobile.drivers.EmulatorMobileDriver;
import mobile.drivers.LocalMobileDriver;
import mobile.drivers.SelenoidMobileDriver;
import mobile.helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.Selenide.*;
import static mobile.helpers.Attach.getSessionId;

public class TestBase {
    private static HostConfig config = ConfigFactory.create(HostConfig.class);

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        switch (config.deviceHost()) {
            case "selenoid":
                Configuration.browser = SelenoidMobileDriver.class.getName();
                break;
            case "emulator":
                Configuration.browser = EmulatorMobileDriver.class.getName();
                break;
            case "local":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            default:
                Configuration.browser = SelenoidMobileDriver.class.getName();
                break;
        }

        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        step("Открываем приложение", () ->
                open());
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
        Attach.attachVideo(sessionId);
    }
}