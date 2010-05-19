package edu.itee.antipodes.web.operator;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.repository.ImageDao;
import edu.itee.antipodes.service.CurrentUser;
import edu.itee.antipodes.service.ITourOperatorManager;
import edu.itee.antipodes.utils.SpringApplicationContext;


@Controller
@RequestMapping("/operator/uploadImages.html")
public class uploadImagesController {
	
	CurrentUser currentUser = new CurrentUser();
	
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private ITourOperatorManager tourOperatorManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public Object showUserForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		int tourID = Integer.parseInt(request.getParameter("tourID"));
		String addorEdit = request.getParameter("state");
		
		if(tourOperatorManager.getTourByID(tourID).getOperator().getOperatorID() != currentUser.getCurrentUserID()) {
			return new RedirectView("/antipodes/accessDenied.html");
		}
		
		ImageDao imd = SpringApplicationContext.getImageDao();
		List<String> files = new ArrayList();
		for(int i=1;i <= (4 - imd.getImageByTourID(tourID).size());i++){
			files.add("file"+i);
		}

		model.addAttribute("tourID", tourID);
		model.addAttribute("files", files);
		model.addAttribute("addorEdit", addorEdit);
		model.addAttribute("numberOfFiles", files.size());
		return "uploadImages";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object upload(@RequestParam("file1") MultipartFile multipartFile1,
			@RequestParam("file2") MultipartFile multipartFile2,
			@RequestParam("file3") MultipartFile multipartFile3,
			@RequestParam("file4") MultipartFile multipartFile4,
			@RequestParam("tourID") int tourID,
			@RequestParam("addorEdit") String addorEdit,
			Model model) {
		
		
		
		if (!multipartFile1.isEmpty()) {
			try {
				tourOperatorManager.UploadFile(applicationContext, multipartFile1, tourID);
			} catch (InvalidParameterException ex) {
				model.addAttribute("errorheader", "Oopps");
				model.addAttribute("errormessage", "Can't upload files of this type. Please try again.");
				return "error";
			}
		}
		if (!multipartFile2.isEmpty()) {
			try {
				tourOperatorManager.UploadFile(applicationContext, multipartFile2, tourID);
			} catch (InvalidParameterException ex) {
				model.addAttribute("errorheader", "Oopps");
				model.addAttribute("errormessage", "Can't upload files of this type. Please try again.");
				return "error";
			}
		}
		if (!multipartFile3.isEmpty()) {
			try {
				tourOperatorManager.UploadFile(applicationContext, multipartFile3, tourID);
			} catch (InvalidParameterException ex) {
				model.addAttribute("errorheader", "Oopps");
				model.addAttribute("errormessage", "Can't upload files of this type. Please try again.");
				return "error";
			}
		}
		if (!multipartFile4.isEmpty()) {
			try {
				tourOperatorManager.UploadFile(applicationContext, multipartFile4, tourID);
			} catch (InvalidParameterException ex) {
				model.addAttribute("errorheader", "Oopps");
				model.addAttribute("errormessage", "Can't upload files of this type. Please try again.");
				return "error";
			}
		}
		if(addorEdit.equalsIgnoreCase("add"))
			return new RedirectView("tourList.html");
		else
			return new RedirectView("editTour.html?tourID=" + tourID);
	}
}
