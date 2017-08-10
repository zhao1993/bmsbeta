package zhao.blog.managementsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhao.blog.managementsystem.dao.PhotoDao;
import zhao.blog.managementsystem.entity.Photo;
import zhao.blog.managementsystem.service.PhotoService;


@Service
@Transactional
public class PhotoServiceImpl extends BaseServiceImpl<Photo> implements PhotoService {
	@Resource private PhotoDao photoDaoImpl;

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.PhotoService#selectPhotosByAlbumId(int)
	 */
	@Override
	public List<Photo> selectPhotosByAlbumId(int albumId) {
		return photoDaoImpl.selectPhotosByAlbumId(albumId);
	}
}
