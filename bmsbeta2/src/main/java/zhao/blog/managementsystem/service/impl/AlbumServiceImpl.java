package zhao.blog.managementsystem.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhao.blog.managementsystem.dao.AlbumDao;
import zhao.blog.managementsystem.entity.Album;
import zhao.blog.managementsystem.service.AlbumService;

@Service
@Transactional
public class AlbumServiceImpl extends BaseServiceImpl<Album> implements AlbumService {
	@Resource
	private AlbumDao albumDaoImpl;
	
	public List<Album> selectAll(){
		return  albumDaoImpl.selectAll();
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.AlbumService#hasAlbumName(java.lang.String)
	 */
	@Override
	public boolean hasAlbumName(String name) {
		return albumDaoImpl.selectByColumn("title",name).size()>0;
	}
	
}
