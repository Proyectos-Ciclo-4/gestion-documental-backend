package com.sofka.docs;

import co.com.sofka.domain.generic.Identity;

public class DownloadId extends Identity {

    private DownloadId(String uuid) {
        super(uuid);
    }

    public DownloadId() {
    }

    public static DownloadId of(String uuid) {
        return new DownloadId(uuid);
    }
}
