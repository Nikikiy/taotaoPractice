package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
    /**
     * @param itemId
     * @return
     */
    TbItem getItemById(long itemId);

    /**
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGridResult getItemList(int page,int rows);
    TaotaoResult createItem(TbItem tbItem,String desc) throws Exception;
}
