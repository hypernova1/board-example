package com.java.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.domain.Criteria;
import com.java.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<ReplyVO> list(Integer bno) {
		return session.selectList("reply.list", bno);
	}

	@Override
	public void create(ReplyVO vo) {
		session.insert("reply.create", vo);
	}

	@Override
	public void update(ReplyVO vo) {
		session.update("reply.update", vo);
	}

	@Override
	public void delete(Integer rno) {
		session.delete("reply.delete", rno);
		
	}

	@Override
	public List<ReplyVO> listPage(Integer bno, Criteria cri) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("cri", cri);
		
		return session.selectList("reply.listPae", paramMap);
	}

	@Override
	public int count(Integer bno) {
		return session.selectOne("reply.count", bno);
	}

}
