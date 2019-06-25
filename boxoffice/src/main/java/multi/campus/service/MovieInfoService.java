package multi.campus.service;

import java.util.List;

import org.json.simple.JSONArray;

import multi.campus.domain.DailyBoxOffice;
import multi.campus.domain.MovieActor;
import multi.campus.domain.MovieGenre;
import multi.campus.domain.MovieInfo;

public interface MovieInfoService {
	// kobis ���� �ڽ����ǽ� 10������ ��ȭ���� �޾ƿ���
	JSONArray getKobisDailyMovieList(String targetDt) throws Exception;
	
	// DB���� �ϰ� �ڽ����ǽ� ����Ʈ ��������
	List<DailyBoxOffice> getAllDailyBoxOffice() throws Exception;
	
	// ��ȭ ���� �Է�
	MovieInfo getMovieInfo(int movieCd) throws Exception;
	
	// �ϰ� �ڽ����ǽ� ���� ���ڵ� �߰�
	int createDailyBoxOffice(DailyBoxOffice dailyBoxOffice) throws Exception;
	
	// ��ȭ ���� ���ڵ� �߰�
	int createMovieInfo(MovieInfo movieInfo) throws Exception;
	
	// ��ȭ �帣 ���ڵ� �߰�
	int createMovieGenre(MovieGenre movieGenre) throws Exception;
	
	// ��ȭ ��� ���ڵ� �߰�
	int createMovieActor(MovieActor movieActor) throws Exception;
	
	// �ϰ� �ڽ����ǽ� ���� ����
	int deleteAllBoxOffce() throws Exception;
}
