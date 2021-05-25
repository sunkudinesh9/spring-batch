package com.dineshlearnings.springbatch.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dineshlearnings.springbatch.model.User;
import com.dineshlearnings.springbatch.repository.UserRespository;

@Component
public class UserDBWritter implements ItemWriter<User> {

	@Autowired
	private UserRespository userRespository;

	@Override
	public void write(List<? extends User> user) throws Exception {
		System.out.println(user);
		userRespository.saveAll(user);
	}

}
