package mobile.config;

import org.aeonbits.owner.Config;

    @Config.Sources({"classpath:local.properties"})
    public interface LocalConfig extends Config {

        @Key("url")
        String url();

        @Key("device")
        String device();

        @Key("ver")
        String ver();
    }