package com.java.service;

import java.util.List;

import com.java.domain.BoardVO;
import com.java.domain.Criteria;

public interface BoardService {

	public void regist(BoardVO vo);
	public BoardVO read(Integer bno);
	public void modify(BoardVO vo);
	public void remove(Integer bno);
	public List<BoardVO> listAll();
	public List<BoardVO> listCriteria(Criteria cri);
	public int listCountCriteria(Criteria cri);
}
