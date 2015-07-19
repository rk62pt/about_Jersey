package tw.com.rk62pt.jersey.models;

import java.util.ArrayList;
import java.util.List;

import tw.com.rk62pt.jersey.models.vo.TestVO;

public class TestService {
	public List<TestVO> list(){
		List<TestVO> voList = new ArrayList<TestVO>();
		TestVO vo1 = new TestVO();
		vo1.setName("王小明");
		vo1.setTel("28825252");
		vo1.setAddr("台北市中正區xx路xx號");
		voList.add(vo1);
		TestVO vo2 = new TestVO();
		vo2.setName("李大同");
		vo2.setTel("0911111111");
		vo2.setAddr("新北市北投區xx路16號");
		voList.add(vo2);
		return voList;
	}
}
