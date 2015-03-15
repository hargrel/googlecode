package edu.itee.antipodes.web.operator;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.service.ITourOperatorManager;

@Controller
@RequestMapping("/operator/uploadFile.html")
public final class uploadFileController {

	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private ITourOperatorManager tourOperatorManager;

	@RequestMapping(method = RequestMethod.POST)
	public Object upload(@RequestParam("file") MultipartFile multipartFile,
			@RequestParam("tourID") int tourID,
			Model model) {

		if (!multipartFile.isEmpty()) {
			try {
				tourOperatorManager.UploadFile(applicationContext, multipartFile, tourID);
			} catch (InvalidParameterException ex) {
				model.addAttribute("errorheader", "Oopps");
				model.addAttribute("errormessage", "Can't upload files of this type. Please try again.");
				return "error";
			}
		}

		return new RedirectView("tourList.html");
	}
}
