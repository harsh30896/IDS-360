package com.ids360.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SystemSettings {

    @Id
    private String id;
    private String appName;
    private String logoUri;
    private String themeJson;
    private boolean enableRefreshTokenRotation;

    @Override
    public String toString() {
        return "SystemSettings{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", logoUri='" + logoUri + '\'' +
                ", themeJson='" + themeJson + '\'' +
                ", enableRefreshTokenRotation=" + enableRefreshTokenRotation +
                '}';
    }
}
