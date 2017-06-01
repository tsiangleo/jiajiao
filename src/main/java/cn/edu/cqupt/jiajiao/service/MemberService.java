package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import cn.edu.cqupt.jiajiao.dao.MemberDao;
import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.MemberType;

public class MemberService 
{
	private MemberDao memberdao = new MemberDao();

	
	/**
	 * 查询所有
	 * @return
	 * @throws SQLException 
	 */
	public List<Member> findAll() throws SQLException{
		return memberdao.findAll();

	}
	/**
	 * 保存会员
	 * @param member
	 * @throws SQLException 
	 */
	public int save(Member member) throws SQLException
	{
		return memberdao.save(member);
	}
	
	/**
	 * 查询是否有用户名为username的会员
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public boolean hasMember(String username) throws SQLException {
		Member mb = memberdao.finMemberByName(username);
		return mb == null ? false : true; 
	}

	/**
	 * 根据用户名查找用户对应的ID
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public Long getID(String username) throws SQLException {
		Member mb = memberdao.finMemberByName(username);
		return mb.getId();
	}

	/**
	 * 登录成功返回1，账号被锁定返回0，密码错误返回-1
	 * @param member
	 * @return
	 * @throws SQLException 
	 */
	public int login(Member member) throws SQLException {
		Member mb = memberdao.finMemberByName(member.getUsername());
		if (mb == null)
			return -1;
		else if(mb.getPassword().equals(member.getPassword())
				&& mb.getRole().equals(member.getRole()))
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
	 * 更新会员的登录信息
	 * @param member
	 * @return
	 * @throws SQLException 
	 */
	public int updateLogin(Member member) throws SQLException {
		return memberdao.updateLogin(member);
		
	}

	

	/**
	 * 根据会员名查询会员
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public Member query(String username) throws SQLException {
		return memberdao.finMemberByName(username);
	}

	/**
	 * 根据会员id查询会员
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public Member query(Long id) throws SQLException {
		return memberdao.finMemberById(id);
	}
	

	/**
	 * 修改邮箱信息
	 * @param memberid5
	 * @param email5
	 * @return
	 * @throws SQLException 
	 */
	public int updateEmail(Long memberid5, String email5) throws SQLException {
		
		String sql = "UPDATE t_member SET email='"+email5+"' WHERE id="+memberid5+"";		
		return memberdao.updateBySQL(sql);
	}


	/**
	 * 修改密码
	 * @param memberid6
	 * @param newpassword
	 * @return
	 * @throws SQLException 
	 */
	public int updatePassword(Long memberid6, String newpassword) throws SQLException {
		String sql = "UPDATE t_member SET password='"+newpassword+"' WHERE id="+memberid6+"";		
		return memberdao.updateBySQL(sql);
	}


	public List<Member> findMemberBySQL(String sql) throws SQLException {
		return memberdao.findMemberBySQL(sql);
	}


	public int updateBalance(Long id4, Integer balance) throws SQLException {
		String sql = "UPDATE t_member SET balance=balance+"+balance+" WHERE id="+id4+"";		
		return memberdao.updateBySQL(sql);
	}


	public int updateSearchRank(Long id5, Integer searchrank) throws SQLException {
		String sql = "UPDATE t_member SET searchrank="+searchrank+" WHERE id="+id5+"";		
		return memberdao.updateBySQL(sql);
	}


	/**
	 * 修改会员的类型信息
	 * @param id6
	 * @param type
	 * @return
	 * @throws SQLException
	 */
	public int updateType(Long id6, String type) throws SQLException {		
		//获得type类型会员的有效期限
		MemberTypeService mts = new MemberTypeService();
		MemberType membertype = mts.findMemberType(type);
		int valdate = membertype.getValidperiod();	//代表valdate天数后过期
		
		Long milliseconds = new java.util.Date().getTime();
		milliseconds = milliseconds + valdate * 24 * 60 * 60 * 1000;		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		//获得到期时间
		String deadline =  sdf.format(milliseconds);
		
		String sql = "UPDATE t_member SET type='"+type+"' ,VIPdeadline='"+deadline+"' WHERE id="+id6+"";
		return memberdao.updateBySQL(sql);
	}


	public int updateBlackList(Long id7, String state) throws SQLException {
		String sql = "UPDATE t_member SET blacklist='"+state+"' WHERE id="+id7+"";		
		return memberdao.updateBySQL(sql);
		
	}

}
