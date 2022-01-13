package mobile.configs;

import org.aeonbits.owner.Config;

@Config.Sources({"system:properties"})
public interface HostConfig extends Config {
    String deviceHost();
}
