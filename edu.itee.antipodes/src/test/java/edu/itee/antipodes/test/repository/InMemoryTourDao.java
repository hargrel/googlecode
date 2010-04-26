package edu.itee.antipodes.test.repository;

import java.util.List;

import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.repository.TourDao;

public class InMemoryTourDao implements TourDao {

    private List<Tour> tourList;

    public InMemoryTourDao(List<Tour> tourList) {
        this.tourList = tourList;
    }

    public List<Tour> getTourList() {
        return tourList;
    }
    
    public Tour getTourByID(int id) {
    	return tourList.get(id);
    }

    public void saveTour(Tour tour) {
    	
    }
    
    public void dropTour(Tour tour) {
    	
    }
    
    public void addTour(Tour tour) {
    	
    }

}