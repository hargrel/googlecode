package edu.itee.antipodes.web.operator;

import java.io.IOException;
import java.security.InvalidParameterException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.service.SimpleTourOperatorManager;
import edu.itee.antipodes.service.TourOperatorManager;

@Controller
@RequestMapping("/operator/uploadFile.html")
public final class uploadFileController {

	@Autowired
	private ApplicationContext applicationContext;

	TourOperatorManager tom = new SimpleTourOperatorManager();

	@RequestMapping(method = RequestMethod.POST)
	public Object upload(@RequestParam("file") MultipartFile multipartFile,
			@RequestParam("tourID") int tourID,
			Model model) {

		if (!multipartFile.isEmpty()) {
			try {
				tom.UploadFile(applicationContext, multipartFile, tourID);
			} catch (InvalidParameterException ex) {
				model.addAttribute("errorheader", "Oopps");
				model.addAttribute("errormessage", "Can't upload files of this type. Please try again.");
				return "error";
			}
		}

		return new RedirectView("editTour.html?tourID="+tourID);
	}
}
