package com.ejemplo01;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.ejemplo01.entity.CapUser;
import com.ejemplo01.repo.CapUserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Ejemplo01ApplicationTests {
	
	@Autowired
	private CapUserRepository userRepo;
	
	/*@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createUserTest() {
		CapUser p = new CapUser();
		p.setFirstName("mitocode");
		p.setLastName("mitoLast");
		p.setEmail("mito@com");
		p.setPassword(encoder.encode("123"));
		CapUser p2 = userRepo.save(p);
		assertTrue(p2.getPassword().equalsIgnoreCase(p.getPassword()));
	}*/

}
