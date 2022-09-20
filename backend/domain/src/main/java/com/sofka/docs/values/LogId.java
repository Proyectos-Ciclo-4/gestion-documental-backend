package com.sofka.docs.values;

import co.com.sofka.domain.generic.Identity;

public class LogId extends Identity {
    private LogId(String uuid){
        super(uuid);
    }

    public LogId(){

    }

    public static LogId of(String uuid) {return new LogId(uuid);}
}
