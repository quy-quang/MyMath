package com.example.quyquang.mymath;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class FormulaNode extends Node {
    public String Name; //s = 0.5*a*hA;
    public Map<String, MyFunction> Functions = new HashMap<String, MyFunction>();

    public FormulaNode(String Name, boolean bActived) {
        this.Name = Name;
        this.bActived = bActived;
    }

    public void AddMethod(String VarName, MyFunction f){
        Functions.put(VarName, f);
    }

    @Override
    public boolean CanActive() {
        int n = Functions.size();
        int c = 0;
        for ( String VarName : Functions.keySet()){
            if (Global.HaveValue(VarName))
                c++;
        }
        return n - 1 == c;
    }

    @Override
    public void Active() {
        String strTargetGetVarName = FindTargetVarName();
        if (strTargetGetVarName == null) return;
        MyFunction f = Functions.get(strTargetGetVarName);
        float v = f.Eval();
        Global.UpdateVarValue(strTargetGetVarName, v);
    }

    private String FindTargetVarName() {
        for ( String VarName : Functions.keySet()){
            if (!Global.HaveValue(VarName))
                return VarName;
        }
        return null;
    }
}
