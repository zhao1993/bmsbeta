package zhao.blog.managementsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhao.blog.managementsystem.constant.Common;
import zhao.blog.managementsystem.constant.CritiqueType;
import zhao.blog.managementsystem.dao.CritiqueDao;
import zhao.blog.managementsystem.entity.Critique;
import zhao.blog.managementsystem.entity.User;
import zhao.blog.managementsystem.service.CritiqueService;
import zhao.blog.managementsystem.service.UserService;

@Service
@Transactional
public class CritiqueServiceImpl extends BaseServiceImpl<Critique> implements CritiqueService {
	@Resource
	private CritiqueDao critiqueDaoImpl;
	@Resource
	private UserService userServiceImpl;
	@Override
	public List<Critique> selectByPage4Init(Integer pagenum, Integer pagesize) {
		if(null==pagesize || pagesize<1){ pagesize = Common.DEFAULT_PAGE_SIZE; }
		int all_page = this.allPage(pagesize);
		if(null==pagenum || pagenum<1){ pagenum = Common.DEFAULT_PAGE_NOW; }
		if(all_page < pagenum){ pagenum = all_page; }
		if(all_page==0) return null;
		return critiqueDaoImpl.selectByPage4Init((pagenum-1)*pagesize,pagesize);
	}

	@Override
	public List<Critique> selectCritiquesByDeck(Integer id) {
		if(id==null)
			return new ArrayList<Critique>();
		return critiqueDaoImpl.selectCritiquesByDeck(id);
	}
	
}
