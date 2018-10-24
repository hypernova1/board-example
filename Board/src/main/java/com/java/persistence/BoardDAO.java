package com.java.persistence;

import java.util.List;

import com.java.domain.BoardVO;

public interface BoardDAO {
	
	public void create(BoardVO vo);
	public BoardVO read(Integer bno);
	public void update(BoardVO vo);
	public void delete(Integer bno);
	public List<BoardVO> listAll();
	
}
