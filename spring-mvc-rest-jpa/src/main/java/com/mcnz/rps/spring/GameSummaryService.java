package com.mcnz.rps.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameSummaryService {

	@Autowired
	private GameSummaryRepository gameSummaryRepository;

}
