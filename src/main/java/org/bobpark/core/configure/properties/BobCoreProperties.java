package org.bobpark.core.configure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("bob-core")
public class BobCoreProperties {

    private boolean enabled;

    public BobCoreProperties() {
        this.enabled = false;
    }

    public BobCoreProperties(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
