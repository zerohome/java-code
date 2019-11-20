package com.noe.shallow;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.noe.shallow.study.restful.bean.User;
import com.noe.shallow.study.restful.bean.UserLog;
import com.noe.shallow.study.restful.controller.IndexController;
import com.noe.shallow.study.restful.dao.jpa.UserLogDao;
import com.noe.shallow.study.restful.dao.mybatis.UserMapper;
import com.noe.shallow.study.restful.jdbc.UserDao;
import com.noe.shallow.study.restful.mq.active.ActiveJmsComponent;
import com.noe.shallow.study.restful.nosql.redis.RedisComponent;
import com.noe.shallow.study.restful.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
public class ShallowAppTests {

	private MockMvc mvc;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
	}

	@Test
	public void contextLoads() throws Exception {
		RequestBuilder request = get("/index");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("hello world"));

		request = get("/index/greeting").param("name", "张小敬");
		mvc.perform(request).andExpect(status().isOk())
				.andExpect(content().string("{\"name\":\"张小敬\",\"title\":\"hello world\"}"));
	}

	@Autowired
	private UserDao useDao;

	@Test
	public void insert() {
		User user = new User();
		user.setName("测试");
		user.setBirthday(new Date());
		int result = useDao.insert(user);
		System.out.println(result);
	}
	
	@Autowired
	private UserLogDao userLogDao;

	@Test
	public void insertByJpa() {
		UserLog entity = new UserLog();
		entity.setUserName("张小敬");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		userLogDao.save(entity);
	}

	@Test
	public void findByJpa() {
		System.out.println(userLogDao.findAll());
	}

	@Test
	public void queryForPage() {
		Pageable pageable = new PageRequest(0, 20, new Sort(new Order(Direction.DESC, "id")));
		Page<UserLog> result = userLogDao.findByUserName("张小敬", pageable);
		System.out.println(result.getContent());
	}

	@Autowired
	private UserService userService;

	@Test
	public void register() {
		String result = userService.register("张小敬", "192.168.1.1");
		System.out.println(result);
	}

	@Autowired 
	private RedisComponent redisComponent;

	@Test
	public void saveRedis() {
		redisComponent.set("noe", "hello world");
	}

	@Test
	public void getFromRedis() {
		System.out.println(redisComponent.get("noe"));
	}

	@Test
	public void delRedis() {
		redisComponent.del("noe");
	}

	@Autowired
	private ActiveJmsComponent activeJmsComponent;

	@Test
	public void send() {
		activeJmsComponent.send("hello world");
	}

	@Autowired
	private UserMapper userMapper;

	@Test
	public void mapper() {
		User user = new User();
		user.setName("小团团");
		user.setBirthday(new Date());
		userMapper.insert(user);
	}

}
