package com.imooc.pojo.vo;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import java.util.List;

/**
 * @author zhangyoubao
 * @version 2020/8/6
 */
public class ItemInfoVO {

    private Items items;
    private List<ItemsImg> itemsImgs;
    private List<ItemsSpec> itemsSpecs;
    private ItemsParam itemsParam;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public List<ItemsImg> getItemsImgs() {
        return itemsImgs;
    }

    public void setItemsImgs(List<ItemsImg> itemsImgs) {
        this.itemsImgs = itemsImgs;
    }

    public List<ItemsSpec> getItemsSpecs() {
        return itemsSpecs;
    }

    public void setItemsSpecs(List<ItemsSpec> itemsSpecs) {
        this.itemsSpecs = itemsSpecs;
    }

    public ItemsParam getItemsParam() {
        return itemsParam;
    }

    public void setItemsParam(ItemsParam itemsParam) {
        this.itemsParam = itemsParam;
    }
}
