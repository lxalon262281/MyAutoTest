package com.lx.functioins;

import com.lx.utils.PhoneUtil;

/*
 *生成11位手机号函数
 */
public class PhoneFunction implements Function{

    @Override
    public String excute(String[] args) {
        return PhoneUtil.getPhone();  //返回11位手机号
    }

    @Override
    public String getReferenceKey() {
        return "phone";
    }
}
