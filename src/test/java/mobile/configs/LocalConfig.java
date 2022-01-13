package mobile.configs;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:local.properties"})
public interface LocalConfig extends Config {
    String url();
    String device();
    String version();
}