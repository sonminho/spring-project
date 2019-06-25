package multi.campus.dao;

import java.util.List;

import multi.campus.domain.DailyBoxOffice;

public interface DailyBoxOfficeDao extends CrudDao<DailyBoxOffice, Integer>{
	// �ϰ� �ڽ����ǽ� ����Ʈ
	List<DailyBoxOffice> getAllDailyBoxOffice() throws Exception;
	
	// �ְ� �ڽ����ǽ� �ʱ�ȭ
	int deleteAllBoxOffce() throws Exception;
}
