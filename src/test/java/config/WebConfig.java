package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("120.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("baseUrl")
    @DefaultValue("https://bercut.com/")
    String baseUrl();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("remoteUrl")
    @DefaultValue("https://bercut.com/")
    String remoteUrl();
}
