package com.projectbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectbase.dao.ProjectBaseDAO;


@Service
public class ProjectBaseServiceImpl implements ProjectBaseService {

	@Autowired
	private ProjectBaseDAO projectBaseDAO;
	
}
