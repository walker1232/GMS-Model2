package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.ImageBean;
import template.AddQuery;
import template.QueryTemplate;
import template.RetrieveQuery;

public class ImageDAOImpl implements ImageDAO{
	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	private ImageDAOImpl() {}
	private QueryTemplate q;
	@Override
	public void insert(ImageBean image) {
		System.out.println("IMAGEDAO에서 받은 정보"+image);
		q = new AddQuery();
		Map<String, Object> param = new HashMap<>();
		param.put("image", image);
		q.play(param);
	}

	@Override
	public ImageBean selectOne(String id) {
		System.out.println("이미지 DAO에서 받은 정보 "+id);
		q = new RetrieveQuery();
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		q.play(param);
		System.out.println("이미지 DAO에서 리턴직전 정보 "+(ImageBean)q.getO());
		return (ImageBean)q.getO();
	}
	

}
