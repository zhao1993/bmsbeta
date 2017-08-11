package zhao.blog.managementsystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhao.blog.managementsystem.dao.PhotoDao;
import zhao.blog.managementsystem.entity.Photo;

@Repository
public class PhotoDaoImpl extends BaseDaoImpl<Photo> implements PhotoDao {

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.PhotoDao#selectPhotosByAlbumId(int)
	 */
	@Override
	public List<Photo> selectPhotosByAlbumId(int albumId) {
		return selectCriteria4Entity("from Photo p where p.album.id = ?", albumId);
	}

}
