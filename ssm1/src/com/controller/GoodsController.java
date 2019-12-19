package com.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Goods;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Resource
	private GoodsService gs;
	
	@RequestMapping("findAll")
	public ModelAndView findAll(ModelAndView mav,@RequestParam(required = true,defaultValue = "1")int page) {
		int size=6;
		PageHelper.startPage(page,size);
		List<Goods> goods=gs.findAll();
		PageInfo<Goods> info=new PageInfo(goods,size);
		mav.setViewName("../goods");
		mav.addObject("info",info);
		return mav;
		
	}
	@RequestMapping("insert")
	public ModelAndView insert(ModelAndView mav) {
		mav.setViewName("../goods_insert");
		return mav;
	}
	@RequestMapping("upgood")
	public ModelAndView upgood(ModelAndView mav,Goods goods,MultipartFile upimg) {
		gs.upgood(goods,upimg);//jsp中不要有name=img 属性为file 和string对不上 要upimg单拿出来
		mav.setViewName("redirect:/goods/findAll.action");
		return mav;
	}
	@RequestMapping("delete")
	public ModelAndView delete(ModelAndView mav,int id) {
		gs.delete(id);
		mav.setViewName("redirect:/goods/findAll.action");
		return mav;
	}
	@RequestMapping("update")
	public ModelAndView update(ModelAndView mav,int id) {
		Goods goods=gs.selectByid(id);
		mav.addObject("goods", goods);
		mav.setViewName("../goods_update");
		return mav;
	}
	@RequestMapping("select")
	public ModelAndView select(ModelAndView mav,String selectgood,@RequestParam(required = true,defaultValue = "1") int page) {
		int size=6;
		PageHelper.startPage(page,size);
		List<Goods> goods =gs.selectgoods(selectgood);
		PageInfo<Goods> info=new PageInfo<Goods>(goods, size);
		mav.setViewName("../goods");
		mav.addObject("info", info);
		return mav;
	}
	
	
	
	
	
	

}
