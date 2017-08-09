package zhao.blog.managementsystem.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhao.blog.managementsystem.dao.DailyDao;
import zhao.blog.managementsystem.entity.Daily;
import zhao.blog.managementsystem.service.DailyService;

@Service
@Transactional
public class DailyServiceImpl extends BaseServiceImpl<Daily> implements DailyService {
	@Resource
	private DailyDao dailyDaoImpl;
	
	public List<Daily> selectAll(){
		return  dailyDaoImpl.selectAll();
	}
	
}
