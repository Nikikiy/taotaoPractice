package com.taotao.service.impl;
import com.taotao.pojo.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(long itemId) {
        System.out.println("hello service1");
        TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
        System.out.println("hello service2");
        return tbItem;
    }

}
