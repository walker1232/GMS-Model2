package template;
import java.lang.reflect.Field;

import domain.MemberBean;
import enums.Domain;

public class ColumnFinder {
	public static String find(Domain dom) {
		String s = "";
		Class<MemberBean> clazz = null;
		switch (dom) {
		case MEMBER:
			clazz=MemberBean.class;
			break;
		default:
			break;
		}
		Field[] f = clazz.getDeclaredFields();
		for (int i=0; i<f.length; i++) {
			s += (i!=(f.length-1))?
					f[i].getName()+",":
						f[i].getName();
		}
		System.out.println("ColumFinder 클래스 들어옴");
		return s;
	}
}
