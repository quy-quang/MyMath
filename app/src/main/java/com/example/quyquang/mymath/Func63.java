package com.example.quyquang.mymath;

class Func63 extends MyFunction {
    @Override
    public float Eval() {
        return Global.GetValue("S")/ Global.GetValue("p");

    }
}
