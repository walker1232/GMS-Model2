package service;

import java.util.List;
import java.util.Map;

import dao.ImageDAO;
import dao.ImageDAOImpl;
import domain.ImageBean;

public class ImageServiceImple implements ImageService{
	private static ImageService instance = new ImageServiceImple();
	public static ImageService getInstance() {return instance;}
	private ImageServiceImple() {}
	@Override
	public void create(ImageBean image) {
		System.out.println("ImageServiceImple에서 받은 정보 "+image);
		ImageDAOImpl.getInstance().insert(image);
		
	}
	@Override
	public List<ImageBean> search(Map<?, ?> param) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ImageBean retrieve(String id) {
		System.out.println("이미지 리트리브에서 받은 정보 "+id);
		return ImageDAOImpl.getInstance().selectOne(id);
	}
	
	
	
}
