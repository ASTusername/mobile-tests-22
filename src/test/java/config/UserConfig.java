package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:auth.properties")
public interface UserConfig extends Config{
    @Key("user")
    String login();
    @Key("key")
    String password();
}
