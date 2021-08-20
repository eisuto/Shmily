package com.poi.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class ResultVo {
    private static final long serialVersionUID = 1L;

    private PageInfo<?> page;
    private List<?> list;

    public ResultVo(List<?> list) {
        this.page = new PageInfo<>(list);
        this.list = list;
    }
}
