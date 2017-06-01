package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import cn.edu.cqupt.jiajiao.dao.NewsDao;
import cn.edu.cqupt.jiajiao.domain.News;

public class NewsService {

	private NewsDao newsdao = new NewsDao();
	
	public int save(News news) throws SQLException {
		return newsdao.save(news);
	}

	public List<News> findAll() throws SQLException {
		return  newsdao.findAll();
	}

	public News findNews(Long newsid) throws SQLException {
		return newsdao.findNews(newsid);
	}

	/**
	 * 更新点击数
	 * @param newsid
	 * @throws SQLException 
	 */
	public void updateClick(Long newsid) throws SQLException {
		newsdao.updateClick(newsid);	
	}

	public int delete(Long newsid) throws SQLException {
		return newsdao.delete(newsid);
	}

	/**
	 * 根据新闻类型查找新闻
	 * @param type
	 * @return
	 * @throws SQLException 
	 */
	public List<News> findByType(String type) throws SQLException {
		String sql = null;
		if(type.equals("不限"))
			sql = "SELECT * FROM t_news";
		else
			sql = "SELECT * FROM t_news WHERE type='"+type+"'";
		return  newsdao.findBySQL(sql);
	}

	/**
	 * 返回新闻类型
	 */
	public List<String> queryNewsType()
	{
		return  newsdao.queryNewsType();
	}

	/**
	 * 返回点击数前10的新闻
	 * @return
	 * @throws SQLException 
	 */
	public List<News> findTop10Click() throws SQLException {
		String sql = "SELECT * FROM t_news ORDER BY click DESC";
		return  newsdao.findBySQL(sql);
	}

	/**
	 * 返回新闻总条数
	 * @return
	 */
	public int getNewsNum() {
		return  newsdao.getNewsNum();
	}

	/**
	 * 返回从fromindex之后的PageSize条大小的记录
	 * @param fromIndex
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public List<News> findAll(int fromIndex, int pageSize) {
		String sql = "SELECT * FROM t_news ORDER BY id DESC LIMIT "+fromIndex+","+pageSize;
		return  newsdao.findBySQL(sql);
	}

	/**
	 * 返回类型为type的新闻的条数
	 * @param type
	 * @return
	 */
	public int getNewsNumByType(String type) {
		try {
			return this.findByType(type) == Collections.EMPTY_LIST ? 0 : this.findByType(type).size();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 返回从fromindex之后的PageSize条大小的记录
	 * @param fromIndex
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public List<News> findByType(String type, int fromIndex, int pageSize) {
		
		String sql = null;
		if(type.equals("不限"))
			sql = "SELECT * FROM t_news ORDER BY id DESC LIMIT "+fromIndex+","+pageSize;
		else
			sql = "SELECT * FROM t_news  WHERE type='"+type+"' ORDER BY id DESC LIMIT "+fromIndex+","+pageSize;
		return  newsdao.findBySQL(sql);
	}
}
