package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
/**
 * 
 * 此类描述的是：
 * <p>Title: ItemController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("item/{itemid}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemid) {
		return itemService.getItemById(itemid);
	}
	/******
	 * 
	 * 此类描述的是：
	 * <p>Title:getItemList</p>
	 * <p>Description: </p>
	 * <p>Company: www.itcast.cn</p> 
	 * @version 1.0
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
}
