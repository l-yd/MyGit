package com.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import com.mapper.GoodsMapper;
import com.pojo.Goods;
import com.pojo.GoodsExample;
import com.pojo.GoodsExample.Criteria;

@Service
public class GoodsService {
	@Resource
	private GoodsMapper gm;
	public List<Goods> findAll() {
		GoodsExample ge=new GoodsExample();
		Criteria c=ge.createCriteria();
		return gm.selectByExample(ge);
	}
	public void upgood(Goods goods,MultipartFile upimg) {
		String Pname=upimg.getOriginalFilename();//此方法为得到upimg的路径值
		if(goods.getId()==null) {
			if(!Pname.isEmpty()) {
				upfile(Pname, upimg, goods);
			}
			gm.insert(goods);
		}else{
			if(goods.getImg()!=" "&&!Pname.isEmpty()){
				downimg(goods.getImg());
				upfile(Pname, upimg, goods);
			}
			gm.updateByPrimaryKey(goods);
		}
	}
	private void upfile(String Pname,MultipartFile upimg,Goods goods) {
		String newname=UUID.randomUUID()+Pname.substring(Pname.indexOf("."));
		goods.setImg(newname);
		File f=new File("d://aa//"+newname);
		try {
			upimg.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("更新图片失败");
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		Goods goods=gm.selectByPrimaryKey(id);
		if(goods.getImg()!=" ") {
			downimg(goods.getImg());
		}
		gm.deleteByPrimaryKey(id);
	}
	public void downimg(String img) {
		File f=new File("d://aa//"+img);
		if(f.delete()) {
		}else {
			System.out.println("删除失败");
		}
	}
	public Goods selectByid(int id) {
		return gm.selectByPrimaryKey(id);
	}
	public List<Goods> selectgoods(String selectgood) {
		GoodsExample ge=new GoodsExample();
		Criteria c=ge.createCriteria();
		c.andNameLike("%"+selectgood+"%");
		return gm.selectByExample(ge);
	}


}
