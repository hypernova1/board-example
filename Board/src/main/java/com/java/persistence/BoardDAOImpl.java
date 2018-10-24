package com.java.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.domain.BoardVO;
import com.java.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;
	private String namespace = "com.java.mapper.boardMapper";
	
	@Override
	public void create(BoardVO vo) {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public BoardVO read(Integer bno) {
		return session.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(BoardVO vo) {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer bno) {
		session.delete(namespace + ".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public List<BoardVO> listPage(int page) {
		
		if(page <= 0) page = 1;

		page = (page - 1) * 10;
		
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) {
		return session.selectOne(namespace + ".countPaging", cri);
	}

}
