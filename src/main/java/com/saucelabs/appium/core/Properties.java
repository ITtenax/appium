package com.saucelabs.appium.core;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

/**
 * User: Valentyn_Kvasov
 * Date: 28.09.2015
 * Time: 22:12
 */

@Resource.Classpath("testing.properties")
public class Properties {
    private static final Properties instance = new Properties();

    private Properties(){
        PropertyLoader.populate(this);
    }

    @Property("platform_version")
    private String platform_version;

    @Property("platform_name")
    private String platform_name;

    @Property("hub_url")
    private String hub_url;

    @Property("hub_port")
    private String hub_port;

    @Property("app_path")
    private String app_path;

    @Property("app_package")
    private String app_package;

    @Property("device_name")
    private String device_name;

    @Property("app_activity")
    private String app_activity;

    public static Properties getInstance() {
        return instance;
    }

    public String getDeviceName() {
        return device_name;
    }

    public String getAppActivity() {
        return app_activity;
    }

    public String getAppPackage() {
        return app_package;
    }

    public String getAppPath() {
        return app_path;
    }

    public String getHubPort() {
        return hub_port;
    }

    public String getHubUrl() {
        return hub_url;
    }

    public String getPlatformName() {
        return platform_name;
    }

    public String getPlatformVersion() {
        return platform_version;
    }

}
