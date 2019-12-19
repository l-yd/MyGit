package com.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.UserMapper;
import com.pojo.User;
import com.pojo.UserExample;
import com.pojo.UserExample.Criteria;

@Service
public class UserService {
	@Resource
	private UserMapper um;
	public User userlogin(User user) {
		UserExample ue=new UserExample();
		Criteria c=ue.createCriteria();
		c.andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
		List<User> users=um.selectByExample(ue);
		return users.isEmpty()?null:users.get(0);
	}

}
