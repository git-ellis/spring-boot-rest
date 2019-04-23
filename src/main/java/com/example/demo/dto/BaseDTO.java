package com.example.demo.dto;

import com.example.demo.util.ConvertUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BaseDTO<T> {
    public abstract void copyPropsTo(T t);
    public abstract T convert();

    protected void copyProperties(Object soruce, T t) {
        String[] nullProperties = this.getNullProperties(soruce);
        BeanUtils.copyProperties(soruce, t, nullProperties);
    }

    protected String[] getNullProperties(Object obj) {
        List<String> nullPropNames = new ArrayList<>();

        BeanWrapper wrapper = new BeanWrapperImpl(obj);
        for (PropertyDescriptor pd : wrapper.getPropertyDescriptors()) {
            String pName = pd.getName();
            if (Objects.isNull(wrapper.getPropertyValue(pName))) {
                nullPropNames.add(pName);
            }
        }

        return nullPropNames.toArray(new String[nullPropNames.size()]);
    }
}
