package com.ayt;

import com.ayt.example.mapper.dao.UsersMapper;
import com.ayt.example.mapper.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;

/**
 * Description
 * Author ayt  on
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.ayt.example.DemoServerApplication.class)
public class DemoServerApplication {
	@Resource
	UsersMapper usersMapper;

	@Test
	public void test() {
		Users users = new Users();
		users.setUserId(464564L);
		users.setPassword(String.valueOf(222));
		users.setPhone("132132123");
		users.setUserName("weww");
		users.setFlag(1);
		usersMapper.insert(users);
	}
}
