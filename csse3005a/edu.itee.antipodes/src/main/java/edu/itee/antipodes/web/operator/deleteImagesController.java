package edu.itee.antipodes.web.operator;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.domain.db.Image;
import edu.itee.antipodes.repository.ImageDao;
import edu.itee.antipodes.utils.SpringApplicationContext;


@Controller
public class deleteImagesController {
	
	@RequestMapping("/operator/deleteImages.html")
	public Object showUserForm(HttpServletRequest request,
			HttpServletResponse response) {
		
		int imageID = Integer.parseInt(request.getParameter("imageID"));
		ImageDao imd = SpringApplicationContext.getImageDao();
		Image image = imd.getImageByID(imageID);
		imd.dropImage(image);
		return new RedirectView("editTour.html?tourID="+image.getTourID());
		
	}
}
