package service;

import java.util.List;
import java.util.Map;

import domain.ImageBean;

public interface ImageService {
	public void create(ImageBean image);
	public ImageBean retrieve(String id);
}
