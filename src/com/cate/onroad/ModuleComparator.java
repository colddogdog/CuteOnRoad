package com.cate.onroad;

import java.util.Comparator;

public class ModuleComparator implements Comparator<Module>{
 
    @Override
    public int compare(Module o1, Module o2) {
        return o1.getId() - o2.getId();
    }
     
}