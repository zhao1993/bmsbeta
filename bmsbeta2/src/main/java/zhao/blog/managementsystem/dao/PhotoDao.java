package zhao.blog.managementsystem.dao;

import java.util.List;

import zhao.blog.managementsystem.entity.Photo;

public interface PhotoDao extends BaseDao<Photo> {

	/**
	 * 根据albumid查询 photos
	 * @param albumId
	 * @return List<Photo>
	 */
	List<Photo> selectPhotosByAlbumId(int albumId);
	
}
