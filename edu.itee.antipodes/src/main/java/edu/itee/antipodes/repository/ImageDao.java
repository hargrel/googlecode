package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.db.Image;

public interface ImageDao {

	public void addImage(Image image);
	
	public List<Image> getImageList();
	
	public List<Image> getImageByTourID(int tourid);
	
	public Image getImageByID(int id);
	
	public void saveImage(Image image);
	
	public void dropImage(Image image);
}
