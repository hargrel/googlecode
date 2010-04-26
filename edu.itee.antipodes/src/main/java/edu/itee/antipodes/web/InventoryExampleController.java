package edu.itee.antipodes.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.itee.antipodes.service.TourManager;

public class InventoryExampleController implements Controller {
	
	private TourManager tourManager;

    public ModelAndView handleRequest(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, IOException {
    	
    	Map<String, Object> myModel = new HashMap<String, Object>();
    	myModel.put("tours", this.tourManager.getTours());

        return new ModelAndView("inventoryexample", "model", myModel);
        
    }
    
    public void setTourManager(TourManager tourManager) {
        this.tourManager = tourManager;
    }

}





















/*@Controller
public class ExampleInventoryController {
	
	private TourManager tourManager;	

	@Autowired
	public ExampleInventoryController(TourManager tourManager) {
		this.tourManager = tourManager;
	}

	@RequestMapping("/inventory.html")
	public String showTourList(ModelMap model) {
		//List<Tour> tours = tourManager.getTours();
		//model.addAttribute(tours);
		model.addAttribute("hi", "This is a test!!");
		return "inventory";
	}

	// Used to add the fake classes... i think...
	public void setTourManager(TourManager tourManager) {
		this.tourManager = tourManager;
	}
	
}


	private TourManager tourManager;

@Autowired
public ExampleInventoryController(TourManager tourManager) {
	this.tourManager = tourManager;
}

@ModelAttribute("tours")
public Collection<Tour> populateTours() {
	return this.tourManager.getTours();
}


@RequestMapping("/inventory.html")
public String showTourList(ModelMap model) {
	model.addAttribute("tours", this.tourManager.getTours());
	model.addAttribute("hi", "hi!");
	return "inventory";
}

	private Tour tour1 = new Tour();
tour1.setTourID(1);
tour1.setTourName("Belle");
tour1.setTourDesc("C'est vraiment belle");
tour1.setPrice(20.50);
tour1.setTotalDays(3);

List<Tour> tourList = new ArrayList<Tour>();
tourList.add(tour1);

tourManager.setTours(tourList);


*/