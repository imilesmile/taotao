package com.common.pojo;

import java.util.List;

/**
 * Created by HM on 16/12/26.
 */
public class EasyUIDataGridResult {
    private long total;
    private List<?> rows;


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
