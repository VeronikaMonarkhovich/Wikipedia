package mobile.configs;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:emulator.properties"})
public interface EmulatorConfig extends Config {
    String url();
    String device();
    String version();
}
