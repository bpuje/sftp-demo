package com.example.sftpdemo.service;

import org.apache.camel.builder.RouteBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class SFTPDownloadFileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception
    {
        URI fromFtpUrl = new URIBuilder()
                .setScheme("sftp")
                .setHost("127.0.0.1")
                .setPort(9922)
                .setPath("in")
                .addParameter("username", "foo")
                .addParameter("password", "pass")
                .addParameter("passiveMode", "false")
                .addParameter("antInclude", "*_TURRETA_*")
                .addParameter("initialDelay", "10s")
                .addParameter("delay", "50")
                .addParameter("moveFailed", "/home/foo/error")
                .addParameter("move", "/home/foo/done")
                .addParameter("preMove", "/home/foo/in-progress")
                .addParameter("readLock", "changed")
                .addParameter("readLockMinAge", "1m")
                .addParameter("readLockTimeout", "70000")
                .addParameter("readLockCheckInterval", "5000")
                .addParameter("stepwise", "false")
                .addParameter("useUserKnownHostsFile", "false")
                .build();

        from(fromFtpUrl.toString())
                .setHeader("useId").simple("system123")
                .setHeader("fileName").simple("${file:name}")
                .bean(SFTPService.class, "downloadAndProcessFile(${body}, ${headers})")
                .log("Downloaded file ${file:name} complete.");
    }
}
