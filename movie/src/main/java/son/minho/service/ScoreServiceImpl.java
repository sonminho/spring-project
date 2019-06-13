package son.minho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import son.minho.dao.ScoreDao;
import son.minho.domain.Score;

@Repository
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	ScoreDao scoreDao;
	
	@Override
	public int countMovieScore(int movieId) throws Exception {
		System.out.println("���񽺿��ä� " + movieId);
		return scoreDao.countMovieScore(movieId);
	}

	@Override
	public int create(Score score) throws Exception {
		System.out.println("���� ��ü�� �����մϴ�" + score);
		return scoreDao.insert(score);
	}

	@Override
	public List<Score> getScoreList(int movieId) throws Exception {
		return scoreDao.getScoreList(movieId);
	}

	@Override
	public int delete(int scoreId) throws Exception {
		return scoreDao.delete(scoreId);
	}

}
