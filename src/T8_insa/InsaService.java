package T8_insa;

import java.util.Calendar;

public class InsaService {
	InsaVO vo = null;
	
	// 오늘 날짜를 구하기
	public InsaVO getDefaultDate() {
		vo = new InsaVO();
		
		Calendar cal = Calendar.getInstance(); // 객체 생성하지 않고 클래스이름. 으로 불러옴
		vo.setCbYY(cal.get(Calendar.YEAR) + "");  // 오늘의 연도  // 안이 객체고 밖이 String이라서 강제로 문자화
		vo.setCbMM(cal.get(Calendar.MONTH) + 1 + "");  // 0월부터 출력
		vo.setCbDD(cal.get(Calendar.DATE) + "");  // Date LocalDate Calendar 모두 많이 사용함
		
		return vo;
	}
	
	
}
