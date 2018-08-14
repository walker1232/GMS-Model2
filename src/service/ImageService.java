package service;

import java.util.List;
import java.util.Map;

import domain.ImageBean;

public interface ImageService {
	public void create(ImageBean image);
	public List<ImageBean> search(Map<?,?>param);
	public ImageBean retrieve(String seq);
}
