package com.example.quyquang.mymath;

class Func62 extends MyFunction {

    @Override
    public float Eval() {
        return Global.GetValue("S")/ Global.GetValue("r");
    }
}
