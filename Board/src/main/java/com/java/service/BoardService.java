package com.java.service;

import java.util.List;

import com.java.domain.BoardVO;

public interface BoardService {

	public void regist(BoardVO vo);
	public BoardVO read(Integer bno);
	public void modify(BoardVO vo);
	public void remove(Integer bno);
	public List<BoardVO> listAll();
}
