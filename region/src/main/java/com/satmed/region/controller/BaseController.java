package com.satmed.region.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.region.models.dto.VersionInfo;


@RestController
@RequestMapping("/")
public class BaseController {
    
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("")
    public VersionInfo base() {
        return new VersionInfo(appName, appVersion);
    }

}
