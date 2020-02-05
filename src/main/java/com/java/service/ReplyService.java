package com.java.service;

import java.util.List;

import com.java.domain.Criteria;
import com.java.domain.ReplyVO;

public interface ReplyService {

	public void addApply(ReplyVO vo);
	public List<ReplyVO> listReply(Integer bno);
	public void modifyReply(ReplyVO vo);
	public void deleteReply(Integer rno);
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri);
	public int count(Integer bno);
}
