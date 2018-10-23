package com.java.persistence;

import com.java.board.MemberVO;

public interface MemberDAO {

	public String getTime();
	public void insertMember(MemberVO vo);
	public MemberVO readMember(String userid) throws Exception;
	public MemberVO readWithPW(String userid, String pw) throws Exception;
}