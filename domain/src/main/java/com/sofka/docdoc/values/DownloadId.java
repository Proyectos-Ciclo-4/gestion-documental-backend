package com.sofka.docdoc.values;

import co.com.sofka.domain.generic.Identity;

public class DownloadId extends Identity {

    public DownloadId(String uuid) {
        super(uuid);
    }

    public DownloadId() {
    }

    public static DownloadId of(String uuid) {
        return new DownloadId(uuid);
    }
}
