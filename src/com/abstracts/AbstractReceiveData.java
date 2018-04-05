package com.abstracts;

public abstract class AbstractReceiveData<T> {

    public T analyseReceivedStr(String str){
        return isReceivedNotNull(str)?analyse(str):null;
    }

    abstract public T analyse(String str);

    private boolean isReceivedNotNull(String str){
        if(null == str){
            return false;
        }else if("".equals(str)){
            return false;
        }
        return true;
    }
}
