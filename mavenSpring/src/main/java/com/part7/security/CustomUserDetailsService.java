package com.part7.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.part7.domain.CustomUser;
import com.part7.domain.MemberVO;
import com.part7.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Setter(onMethod_ = { @Autowired })
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.warn("Load User By UserName :: " + userName);
		
		MemberVO vo = memberMapper.read(userName);
		log.warn("queried by member mapper :: " + vo);
		
		return vo == null ? null : new CustomUser(vo);
	}
}
