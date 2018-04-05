package com.factorys;

import com.abstracts.AbstractReceiveData;
import com.impls.XMLReceivedAnalysor;

public class AnalysReceiveFoctory {

    public static AbstractReceiveData getAnalysor(){
        AbstractReceiveData analysor = new XMLReceivedAnalysor();
        return analysor;
    }
}
