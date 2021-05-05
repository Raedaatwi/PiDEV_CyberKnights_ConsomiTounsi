package Cyberknights.Pidev.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import Cyberknights.Pidev.Model.Ads;
import Cyberknights.Pidev.Model.AdsExcelExporter;
import Cyberknights.Pidev.Model.Product;
import Cyberknights.Pidev.Service.AdsService;

@RestController
public class AdsController {
	@Autowired
	AdsService AdsService;
	
	 @GetMapping("/Ads/export/excel")
	    public void exportToExcel(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Ads> listAds = AdsService.listAll();
	         
	        AdsExcelExporter excelExporter = new AdsExcelExporter(listAds);
	         
	        excelExporter.export(response);    
	    }  
	
	 @RequestMapping(value = "/AcceptAds", method = RequestMethod.PUT)
		public boolean Addlike(@RequestBody Ads ads){
			return AdsService.AcceptAds(ads) ;
		}
	 
	 @RequestMapping(value = "/DeclineAds", method = RequestMethod.PUT)
		public boolean DeclineAds(@RequestBody Ads ads) {
			return AdsService.DeclineAds(ads);
		}
		
	// Affichage all Ads
	@RequestMapping(value = "/DisplayAllAds", method = RequestMethod.GET)
	public List<Ads> getAllAds() {
		return AdsService.listAll();
	    }
	
	
   
	@RequestMapping(value = "/AddAds", method = RequestMethod.POST)
	public Ads addAds(@RequestBody Ads ads) {
		return AdsService.addAds(ads) ;
	    }

	@RequestMapping(value = "/DeleteAds/{id}", method = RequestMethod.DELETE)
	public void deleteAds(@PathVariable Long id) {
		 AdsService.deleteAds(id);

	    }

	@PutMapping(value = "/ModifyAds")
	public Ads updateAds(@RequestBody Ads ads) {
		return AdsService.updateAds(ads);
	   }
}
