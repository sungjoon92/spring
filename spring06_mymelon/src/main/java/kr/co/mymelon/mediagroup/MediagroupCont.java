package kr.co.mymelon.mediagroup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MediagroupCont {

	public MediagroupCont() {
		System.out.println("MediagroupCont() 객체 생성됨");
	}//class end
	
	//http://localhost:9095/mediagroup/media.do
	@GetMapping("/mediagroup/media.do")
	public String media() {
		return "mediagroup/media";
	}//media() end

}//class end

