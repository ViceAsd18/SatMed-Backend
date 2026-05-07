package com.satmed.profesional.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.profesional.models.dto.VersionInfo;

@RestController
@RequestMapping("/")
public class BaseController {
    
    @Value("${app.version}")
    private String appVersion;

    @Value("${app.name}")
    private String appName;

    @GetMapping("")
    public VersionInfo getVersionInfo() {
        return new VersionInfo(appVersion, appName);
    }

}
