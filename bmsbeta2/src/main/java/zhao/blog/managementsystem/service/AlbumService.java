package zhao.blog.managementsystem.service;

import zhao.blog.managementsystem.entity.Album;

public interface AlbumService extends BaseService<Album> {

	/**
	 * ajax 判断相册名称是否存在
	 * @param name
	 * @return 存在返回true 反之false
	 */
	boolean hasAlbumName(String name);

}
