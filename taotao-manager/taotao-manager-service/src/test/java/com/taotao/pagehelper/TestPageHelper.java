package com.taotao.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;

public class TestPageHelper {

	@Test
	public void testPageHelper() throws Exception {
		//1.��mybatis�������ļ������÷�ҳ���
		//2.��ִ�в�ѯ֮ǰ���÷�ҳ������ʹ��PageHelper�ľ�̬����
		PageHelper.startPage(1, 10);
		//3.ִ�в�ѯ
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
		//����Example����
		TbItemExample example = new TbItemExample();
//		Criteria criteria = example.createCriteria();
		List<TbItem> list = itemMapper.selectByExample(example);
		//4.ȡ��ҳ��Ϣ��ʹ��PageInfo����ȡ��
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		System.out.println("�ܼ�¼����" + pageInfo.getTotal());
		System.out.println("�ܼ�ҳ����" + pageInfo.getPages());
		System.out.println("���صļ�¼����" + list.size());
		
		
	}
}
