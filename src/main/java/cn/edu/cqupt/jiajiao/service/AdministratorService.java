package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;
import java.util.List;
import cn.edu.cqupt.jiajiao.dao.AdministratorDao;
import cn.edu.cqupt.jiajiao.domain.Administrator;


public class AdministratorService 
{
	private AdministratorDao administratorDao = new AdministratorDao();

	/**
	 * 查询所有
	 * @return
	 * @throws SQLException 
	 */
	public List<Administrator> findAll() throws SQLException{
		return administratorDao.findAll();

	}
	/**
	 * 保存管理员
	 * @param Administrator
	 * @throws SQLException 
	 */
	public int save(Administrator Administrator) throws SQLException
	{
		return administratorDao.save(Administrator);
	}
	
	/**
	 * 查询是否有用户名为username的管理员
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public boolean hasAdministrator(String username) throws SQLException {
		Administrator mb = administratorDao.finAdministratorByName(username);
		return mb == null ? false : true; 
	}

	/**
	 * 根据用户名查找用户对应的ID
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public Long getID(String username) throws SQLException {
		Administrator mb = administratorDao.finAdministratorByName(username);
		return mb.getId();
	}

	/**
	 * 登录成功返回1，账号被锁定返回0，密码错误返回-1
	 * @param Administrator
	 * @return
	 * @throws SQLException 
	 */
	public int login(Administrator Administrator) throws SQLException {
		System.out.println("AdministratorService.login(),"+Administrator);
		
		Administrator mb = administratorDao.finAdministratorByName(Administrator.getUsername());
		if (mb == null)
			return -1;
		else if(mb.getPassword().equals(Administrator.getPassword())
				&& mb.getRole().equals(Administrator.getRole()))
		{
			if(mb.getBlacklist().equals("否"))
				return 1;
			else
				return 0;
		}
		else
			return -1;
	}
	

	/**
	 * 根据管理员名查询管理员
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public Administrator query(String username) throws SQLException {
		return administratorDao.finAdministratorByName(username);
	}

	/**
	 * 修改密码
	 * @param Administratorid6
	 * @param newpassword
	 * @return
	 * @throws SQLException 
	 */
	public int updatePassword(Long Administratorid6, String newpassword) throws SQLException {
		String sql = "UPDATE t_administrator SET password='"+newpassword+"' WHERE id="+Administratorid6+"";		
		return administratorDao.updateBySQL(sql);
	}


	public List<Administrator> findAdministratorBySQL(String sql) throws SQLException {
		return administratorDao.findAdministratorBySQL(sql);
	}


	public int updateBlackList(Long id7, String state) throws SQLException {
		String sql = "UPDATE t_administrator SET blacklist='"+state+"' WHERE id="+id7+"";		
		return administratorDao.updateBySQL(sql);
		
	}
	/*
	 *删除制定id的管理员 
	 */
	public int delete(Long id) {
		try {
			return administratorDao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
