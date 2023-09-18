package org.sp.springapp.model.gallery;

import java.util.List;

import org.sp.springapp.domain.GalleryImg;

public interface GalleryImgDAO {
	public void insert(GalleryImg galleryImg);
	public List selectAll();
	public GalleryImg select(int gallery_img_idx);
	public void update(GalleryImg galleryImg);
	public void delete(int gallery_img_idx);	//한건 삭제
	public void deleteByGalleryIdx(int gallery_idx);	//부모의 fkey를 이용한 삭제
}
