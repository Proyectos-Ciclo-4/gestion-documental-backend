package docdoc.handle.service;

import static java.util.Objects.isNull;

public class IsNull {

    static public String compareString(String newDoc, String lastDoc) {
        if(isNull(newDoc)){
            return lastDoc;
        }
        return newDoc;
    }

    static public Integer compareInteger(Integer newDoc, Integer lastDoc) {

        if(isNull(newDoc)){
            return lastDoc;
        }
        return newDoc;

    }

}