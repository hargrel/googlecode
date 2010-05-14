package edu.itee.antipodes.web.operator;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class deleteImagesController {
	
	@RequestMapping("/operator/deleteImages.html")
	public Object showUserForm(HttpServletRequest request,
			HttpServletResponse response) {
		return "search";
		/*
		int imageID = Integer.parseInt(request.getParameter("imageID"));
		ImageDao imd = DaoManager.getImageDao();
		Image image = imd.getImageByID(imageID);
		imd.dropImage(image);
		return new RedirectView("editTour.html?tourID="+image.getTourID());
		*/
	}
}
