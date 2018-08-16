package dao;

import java.util.List;
import java.util.Map;

import domain.ImageBean;

public interface ImageDAO {
	public void insert(ImageBean image);
	public List<ImageBean> selectSome(Map<?,?>param);
	public ImageBean selectOne(String id);
}
