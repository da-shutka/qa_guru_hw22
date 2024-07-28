package config;

import com.codeborne.selenide.Configuration;

public class ProjectConfiguration {

    private final WebConfig webConfig;

    public ProjectConfiguration(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public void webConfig() {
        Configuration.baseUrl = webConfig.baseUrl();
        Configuration.browser = webConfig.browser();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.browserSize = webConfig.browserSize();
        Configuration.pageLoadStrategy = "eager";

        if (webConfig.isRemote()) {
            Configuration.remote = webConfig.remoteUrl();
        }
    }
}
