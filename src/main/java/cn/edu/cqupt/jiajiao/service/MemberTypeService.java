package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cqupt.jiajiao.dao.MemberTypeDao;
import cn.edu.cqupt.jiajiao.domain.MemberType;

public class MemberTypeService {

	private MemberTypeDao membertypedao = new MemberTypeDao();
	
	public int save(MemberType membertype) throws SQLException {
		return membertypedao.save(membertype);
	}

	public List<MemberType> findAll() throws SQLException {
		return membertypedao.findAll();
	}

	public MemberType findMemberType(Long membertypeid) throws SQLException {
		return membertypedao.findMemberType(membertypeid);
	}

	public MemberType findMemberType(String typename) throws SQLException {
		return membertypedao.findMemberType(typename);
	}
	
	public int update(MemberType membertype) throws SQLException {
		return membertypedao.update(membertype);
	}

	public int delete(Long memertypeid) throws SQLException {
		return membertypedao.delete(memertypeid);
	}

}
