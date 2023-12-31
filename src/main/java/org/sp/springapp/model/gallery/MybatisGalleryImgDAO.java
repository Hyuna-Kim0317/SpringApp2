package org.sp.springapp.model.gallery;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.sp.springapp.domain.GalleryImg;
import org.sp.springapp.exception.GalleryException;
import org.sp.springapp.exception.GalleryImgException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sp.org.springapp.mybatis.MybatisConfig;

@Repository
public class MybatisGalleryImgDAO implements GalleryImgDAO{
	
	@Autowired
	private MybatisConfig mybatisConfig;
	@Override
	public void insert(GalleryImg galleryImg) throws GalleryImgException {
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		int result=sqlSession.insert("GalleryImg.insert", galleryImg);
		sqlSession.commit();
		mybatisConfig.release(sqlSession);
		
		if(result==0) {
			throw new GalleryImgException("이미지 등록에 실패");
		}
	}

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public GalleryImg select(int gallery_img_idx) {
		return null;
	}

	@Override
	public void update(GalleryImg galleryImg) {
		
	}

	@Override
	public void delete(int gallery_img_idx) {
		
	}
	
	@Override
	public void deleteByGalleryIdx(int gallery_idx) throws GalleryImgException{
		SqlSession sqlSession = mybatisConfig.getSqlSession();
		int result=sqlSession.delete("GalleryImg.deleteByGalleryIdx", gallery_idx);
		sqlSession.commit();
		mybatisConfig.release(sqlSession);
		if(result<1) {
			throw new GalleryImgException("이미지 레코드 삭제 실패");
		}
	}

}
