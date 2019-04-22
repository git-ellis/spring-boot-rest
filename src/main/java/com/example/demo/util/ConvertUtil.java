package com.example.demo.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConvertUtil {

//    public static void copyProperties(Object soruce, Object target) {
//        String[] nullProperties = ConvertUtil.getNullProperties(soruce);
//        BeanUtils.copyProperties(soruce, target, nullProperties);
//    }
//
//    public static String[] getNullProperties(Object obj) {
//        List<String> nullPropNames = new ArrayList<>();
//
//        BeanWrapper wrapper = new BeanWrapperImpl(obj);
//        for (PropertyDescriptor pd : wrapper.getPropertyDescriptors()) {
//            String pName = pd.getName();
//            if (Objects.isNull(wrapper.getPropertyValue(pName))) {
//                nullPropNames.add(pName);
//            }
//        }
//
//        return nullPropNames.toArray(new String[nullPropNames.size()]);
//    }
}
