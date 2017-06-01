package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cqupt.jiajiao.dao.EvaluationDao;
import cn.edu.cqupt.jiajiao.domain.Evaluation;

public class EvaluationService {

	private EvaluationDao evaluationdao= new EvaluationDao();
	public int save(Evaluation evaluation)  {
		try {
			return evaluationdao.save(evaluation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	
	public List<Evaluation>  findAll(Long teacherid)
	{
		try {
			return evaluationdao.findAll(teacherid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
