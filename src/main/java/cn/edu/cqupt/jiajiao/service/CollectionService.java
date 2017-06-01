package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.jiajiao.dao.CollectionDao;
import cn.edu.cqupt.jiajiao.dao.MemberDao;
import cn.edu.cqupt.jiajiao.domain.Collection;
import cn.edu.cqupt.jiajiao.domain.Member;

public class CollectionService 
{
	private CollectionDao collectiondao = new CollectionDao();

	public int save(Collection collection) throws SQLException
	{
		return collectiondao.save(collection);
	}

	/**
	 * 查询会员编号为studentid的学员是否收藏了教员编号为teacherid的教员
	 * @param memberid
	 * @param teacherid
	 * @return
	 * @throws SQLException 
	 */
	public boolean hasCollection(Long studentid, Long teacherid) throws SQLException {
		ArrayList<Collection> collections = (ArrayList<Collection>) collectiondao.findAll(studentid);
		for(int i = 0;i<collections.size();i++)
		{
			if( collections.get(i).getTeacherid() == teacherid )
				return true;
		}
		return false;
	}
	
	public List<Collection> findAll(Long studentid) throws SQLException {
		return collectiondao.findAll(studentid);
	}

	public int delete(Long id) throws SQLException {
		return collectiondao.delete(id);
	}
}
