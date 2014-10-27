package com.projectbase.web.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectbase.service.ProjectBaseService;

@Component
public class InicioHelperImpl implements InicioHelper {

	@Autowired
	private ProjectBaseService projectBaseService;

}
