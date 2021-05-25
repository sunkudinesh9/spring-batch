package com.dineshlearnings.springbatch.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.dineshlearnings.springbatch.model.User;

@Component
public class UserProcess implements ItemProcessor<User, User> {

	@Override
	public User process(User item) throws Exception {
		return User.builder().address("modified" + item.getAddress()).name("modified" + item.getName()).build();
	}

}
