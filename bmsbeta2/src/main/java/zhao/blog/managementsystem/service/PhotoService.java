package zhao.blog.managementsystem.service;

import java.util.List;

import zhao.blog.managementsystem.entity.Photo;

public interface PhotoService extends BaseService<Photo> {

	/**
	 * 根据Album的ID查询 包含的Photo
	 * @param albumId 
	 * @return List<Photo>
	 */
	List<Photo> selectPhotosByAlbumId(int albumId);

}
