package com.java.service;

import java.util.List;

import com.java.domain.BoardVO;
import com.java.domain.Criteria;
import com.java.domain.SearchCriteria;

public interface BoardService {

	public void regist(BoardVO vo);
	public BoardVO read(Integer bno);
	public void modify(BoardVO vo);
	public void remove(Integer bno);
	public List<BoardVO> listAll();
	public List<BoardVO> listCriteria(Criteria cri);
	public int listCountCriteria(Criteria cri);
	public List<BoardVO> listSearchCriteria(SearchCriteria cri);
	public int listSearchCount(SearchCriteria cri);
}
