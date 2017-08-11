package zhao.blog.managementsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhao.blog.managementsystem.dao.AlbumDao;
import zhao.blog.managementsystem.dao.PhotoDao;
import zhao.blog.managementsystem.entity.Album;
import zhao.blog.managementsystem.entity.Photo;
import zhao.blog.managementsystem.service.PhotoService;


@Service
@Transactional
public class PhotoServiceImpl extends BaseServiceImpl<Photo> implements PhotoService {
	@Resource private PhotoDao photoDaoImpl;
	@Resource private AlbumDao albumDaoImpl;

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.PhotoService#selectPhotosByAlbumId(int)
	 */
	@Override
	public List<Photo> selectPhotosByAlbumId(int albumId) {
		return photoDaoImpl.selectPhotosByAlbumId(albumId);
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.PhotoService#selectAlbumByPhotoId(int)
	 */
	@Override
	public Album selectAlbumByPhotoId(int photoId) {
		return photoDaoImpl.selectById(photoId).getAlbum();
	}
	
}
