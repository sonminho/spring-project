package multi.campus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor	
public class MovieInfo {
	int movieCd; // ��ȭ �ڵ�
	String movieNm; // ��ȭ ����
	int prdtYear; // ���� ����
	String openDt; // ������
	String nationNm; // ���� ����
	String directorNm; // ����
	String imageUrl; // ����� �̹���
}
