package domain;

import lombok.Data;

@Data
public class ExamBean {
	public String examSeq, month, score, memId, subSeq, recordSeq;
	public static final String TEST="TEST";

	

	@Override
	public String toString() {
		return "시험정보 [시험SEQ=" + examSeq + ", 월=" + month + ", 점수=" + score + ", 학생ID=" + memId
				+ ", 과목SEQ=" + subSeq + ", 성적표SEQ=" + recordSeq + "]";
	}
	
}
