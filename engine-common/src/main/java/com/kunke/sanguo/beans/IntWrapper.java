package com.kunke.sanguo.beans;

import lombok.Data;

@Data
public class IntWrapper {
    private Integer id;

    public IntWrapper(Integer id) {
        this.id = id;
    }

    public static IntWrapper me(Integer id) {
        return new IntWrapper(id);
    }
}
