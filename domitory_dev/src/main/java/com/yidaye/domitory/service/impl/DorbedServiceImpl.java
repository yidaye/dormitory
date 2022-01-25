package com.yidaye.domitory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidaye.domitory.dao.DorbedDao;
import com.yidaye.domitory.po.Dorbed;
import com.yidaye.domitory.service.DorbedService;

@Service
public class DorbedServiceImpl implements DorbedService {

	@Autowired
	public DorbedDao dorbedDao;
	//根据条件查询
			public List<Dorbed> find( String b_no, String d_no)
			{
				return dorbedDao.find(b_no, d_no);
			}
			
			//删除
			public int delete( String b_no)
			{
				return dorbedDao.delete(b_no);
					}
			
			public int delepepo(String u_no)
			{
				return dorbedDao.delepepo(u_no);
			}
			
			//添加
			public int add(Dorbed dorbed)
			{
				return dorbedDao.add(dorbed);
			}
			
			//查询入住人数
			public int findpepo(String b_no)
			{
				return dorbedDao.findpepo(b_no);
			}
			
			//查询空余位置
				public int findkong(String b_no)
				{
					return dorbedDao.findkong(b_no);
				}

				//查询入住人数
				public int findwei()
				{
					return dorbedDao.findwei();
				}
				
				public int updtuno(String u_no)
				{
					return dorbedDao.updtuno(u_no);
				}
				
				//查询空余床位
				public List<Integer> findkbed(String b_sex)
				{
					return dorbedDao.findkbed(b_sex);
				}
				
				//查询未分配人
				public List<String> findkpepo(String u_sex)
				{
					return dorbedDao.findkpepo(u_sex);
				}
				
				//分配
				public int update(int id,String u_no)
				{
					return dorbedDao.update(id, u_no);
				}
				
				public int findAlltol(String b_no,String d_no)
				{
					return dorbedDao.findAlltol(b_no, d_no);
				}
				public List<Dorbed> findAll(int pag,int limt,String b_no,String d_no)
				{
					return dorbedDao.findAll(pag, limt, b_no, d_no);
				}
				
				public List<Integer> findk(String b_no,String d_no)
				{
					return dorbedDao.findk(b_no, d_no);
				}
}
