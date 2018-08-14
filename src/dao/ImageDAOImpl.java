package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.ImageBean;
import template.AddQuery;
import template.QueryTemplate;

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
	public List<ImageBean> selectSome(Map<?, ?> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageBean selectOne(String seq) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
