package com.example.sftpdemo.service;

import org.apache.camel.builder.RouteBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Component;

import java.net.URI;

public class SFTPUploadFileRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        URI toFtpUrl = new URIBuilder()
                .setScheme("sftp")
                .setHost("127.0.0.1")
                .setPort(9922)
                .setPath("/foo-home/upload")
                .addParameter("initialDelay", "10s")
                .addParameter("delay", "50")
                .addParameter("username", "foo")
                .addParameter("password", "pass")
                .addParameter("passiveMode", "false")
                .addParameter("useUserKnownHostsFile", "false")
                .build();

        StringBuilder fromURL = new StringBuilder();
        fromURL.append("file:/users/puujee/Desktop/fileTransfer?");
        fromURL.append("antInclude=*_TESTFILE_*&");
        fromURL.append("moveFailed=../error&");
        fromURL.append("move=../done&");
        fromURL.append("preMove=../in-progress&");
        fromURL.append("readLock=changed&");
        fromURL.append("readLockMinAge=1m&");
        fromURL.append("readLockTimeout=70000&");
        fromURL.append("readLockCheckInterval=5000");
        from(fromURL.toString()).to(toFtpUrl.toString());
    }
}
