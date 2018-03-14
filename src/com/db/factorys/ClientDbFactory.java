package com.db.factorys;

import com.db.impls.AddClientUp;
import com.db.interfaces.IAddClientUp;

public class ClientDbFactory {

    public static IAddClientUp addClientUp(){
        return new AddClientUp();
    }
}
