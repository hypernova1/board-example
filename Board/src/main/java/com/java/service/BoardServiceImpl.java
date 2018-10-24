package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.domain.BoardVO;
import com.java.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO vo) {
		dao.create(vo);
	}

	@Override
	public BoardVO read(Integer bno) {
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO vo) {
		dao.update(vo);
	}

	@Override
	public void remove(Integer bno) {
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() {
		return dao.listAll();
	}

}
