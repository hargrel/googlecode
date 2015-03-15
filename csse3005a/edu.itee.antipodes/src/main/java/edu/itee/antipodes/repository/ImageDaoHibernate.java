package edu.itee.antipodes.repository;

import edu.itee.antipodes.domain.db.Image;

import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.*;

public class ImageDaoHibernate extends HibernateDaoSupport implements ImageDao {

	public void addImage(Image image) throws HibernateException{
		getHibernateTemplate().save(image);	
	}			
	@SuppressWarnings("unchecked")
	public List<Image> getImageList() throws HibernateException{
		return getHibernateTemplate().find("from Image");
	}
	public Image getImageByID(int id) {
		return (Image)getHibernateTemplate().get(Image.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Image> getImageByTourID(int tourid) {
		return getHibernateTemplate().find("from Image as IMG where IMG.tourID="+tourid);
	}
	public void saveImage(Image image) throws HibernateException{
		getHibernateTemplate().saveOrUpdate(image);	
	}		
	public void dropImage(Image image) throws HibernateException{
		Object record = getHibernateTemplate().load(Image.class, image.getImageID());
        getHibernateTemplate().delete(record);
    }
	public void dropImageByID(int imageID) throws HibernateException{
		Object record = getHibernateTemplate().load(Image.class, imageID);
        getHibernateTemplate().delete(record);
    }
	
}

