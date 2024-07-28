package tests;

import com.codeborne.selenide.Selenide;
import config.ConfigReader;
import config.ProjectConfiguration;
import config.WebConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    private static final WebConfig webConfig = ConfigReader.Instance.read();

    @BeforeAll
    static void setUp() {
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig);
        projectConfiguration.webConfig();
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
