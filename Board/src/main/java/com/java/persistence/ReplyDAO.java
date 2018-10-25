package com.java.persistence;

import java.util.List;

import com.java.domain.Criteria;
import com.java.domain.ReplyVO;

public interface ReplyDAO {

	public List<ReplyVO> list(Integer bno);
	public void create(ReplyVO vo);
	public void update(ReplyVO vo);
	public void delete(Integer rno);
	public List<ReplyVO> listPage(Integer bno, Criteria cri);
	public int count(Integer bno);
}
