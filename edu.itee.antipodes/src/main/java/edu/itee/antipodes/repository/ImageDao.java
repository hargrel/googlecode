package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.Image;

public interface ImageDao {

	public void addImage(Image image);
	
	public List<Image> getImageList();
	
	public Image getImageByID(int id);
	
	public void saveImage(Image image);
	
	public void dropImage(Image image);
}
