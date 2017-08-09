package zhao.blog.managementsystem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhao.blog.managementsystem.dao.CritiqueDao;
import zhao.blog.managementsystem.entity.Critique;
import zhao.blog.managementsystem.service.CritiqueService;

@Service
@Transactional
public class CritiqueServiceImpl extends BaseServiceImpl<Critique> implements CritiqueService {
	@Resource
	private CritiqueDao critiqueDaoImpl;
}
