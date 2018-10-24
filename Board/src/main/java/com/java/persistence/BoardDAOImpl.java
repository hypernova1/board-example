package com.java.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.domain.BoardVO;

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

}
