package com.kunke.sanguo.beans;

import lombok.Data;

import java.util.List;

@Data
public class ListWrapper {
    private List<?> dataList;

    public ListWrapper(List<?> list) {
        this.dataList = list;
    }

    public static ListWrapper me(List<?> list) {
        return new ListWrapper(list);
    }
}
