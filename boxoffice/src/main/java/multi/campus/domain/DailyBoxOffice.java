package multi.campus.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyBoxOffice {
	int movieCd; // ��ȭ �ڵ�
	String movieNm; // ��ȭ ����
	int rank; // ����
	int rankInten; // ���� ��� ����
	String rankOldAndNew; // ��ŷ ���� ����	
	String openDt; // ��ȭ ������
	long salesAcc; // ���� �����
	int audiCnt; // �ش����� ������
	int audiAcc; // ���� ������
}
