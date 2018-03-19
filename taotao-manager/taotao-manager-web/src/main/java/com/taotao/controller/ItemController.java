package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemCatService;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nikikiy
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        System.out.println("hello dubbo");
        System.out.println(itemId);
        TbItem tbItem = itemService.getItemById(itemId);

        return tbItem;
    }
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(int page,int rows){
        EasyUIDataGridResult result=itemService.getItemList(page,rows);
        return  result;
    }
    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getCatList(@RequestParam(name="id",defaultValue = "0")long parentId){
        List<EasyUITreeNode> result=itemCatService.getItemCatList(parentId);
        return  result;
    }
    @RequestMapping(value = "/item/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult addItem(TbItem item,String desc){
        try {
            TaotaoResult result = itemService.createItem(item,desc);
            return  result;
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500,"failure");
        }
    }
}
