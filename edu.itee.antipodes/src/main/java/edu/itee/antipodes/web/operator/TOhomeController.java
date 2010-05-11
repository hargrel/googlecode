package edu.itee.antipodes.web.operator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.repository.DaoManager;
import edu.itee.antipodes.repository.TourOperatorDao;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;
import edu.itee.antipodes.service.CurrentUser;

@Controller
public class TOhomeController {

	@RequestMapping("/operator/TOhome.html")
	public Object redirect()
	{
		
		return "TOhome";
	}
}
