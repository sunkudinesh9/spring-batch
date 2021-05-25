package com.dineshlearnings.springbatch.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dineshlearnings.springbatch.model.User;
import com.dineshlearnings.springbatch.service.UserService;

@RestController
public class SpringController {

	@Autowired
	private UserService userService;

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@GetMapping("/add")
	public BatchStatus addUser() throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {

		Map<String, JobParameter> maps = new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		JobExecution jobExecuter = jobLauncher.run(job, new JobParameters(maps));
		System.out.println(jobExecuter.getStatus());

		while (jobExecuter.isRunning()) {
			System.out.println("........");
		}

		return jobExecuter.getStatus();
	}

	@GetMapping("/findall")
	public List<User> getAllUsers() {
		return userService.getAlluser();
	}
}
