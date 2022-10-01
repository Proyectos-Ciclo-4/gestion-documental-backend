package com.sofka.docdoc.values;

import co.com.sofka.domain.generic.Identity;

public class BlockChainId extends Identity {

    public BlockChainId(String uuid){
        super(uuid);
    }

    public BlockChainId(){

    }

    public static BlockChainId of(String uuid) {return new BlockChainId(uuid);}
}
