package com.example.quyquang.mymath;

class Func61 extends MyFunction {

    @Override
    public float Eval() {
        return Global.GetValue("r")*Global.GetValue("p");
    }
}
