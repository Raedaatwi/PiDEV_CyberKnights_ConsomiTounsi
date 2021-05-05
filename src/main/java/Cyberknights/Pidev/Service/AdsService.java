package Cyberknights.Pidev.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Cyberknights.Pidev.Model.Ads;
import Cyberknights.Pidev.Model.Product;
import Cyberknights.Pidev.Repository.AdsRepository;

@Service
public class AdsService {
	@Autowired
	AdsRepository<Ads> AdsRepository;
	
	

	@Transactional
	public List<Ads> getAllAds() {
		return (List<Ads>) AdsRepository.findAll();
	}

	@Transactional
	public Ads addAds(Ads ads) {
		return AdsRepository.save(ads);
	}

	@Transactional
	public Ads updateAds(Ads ads) {
		return AdsRepository.save(ads) ;
	}

	@Transactional
	public boolean deleteAds(Long Adsid) {
		AdsRepository.deleteById(Adsid);
		return !AdsRepository.existsById(Adsid);

	}
	
	@Transactional
	public boolean AcceptAds(Ads ads) {
		ads.setStatus("Accepted");
		return AdsRepository.save(ads) != null;
	}
	

	@Transactional
	public boolean DeclineAds(Ads ads){
		ads.setStatus("Declined");
		return AdsRepository.save(ads) != null;
	}
	

	
	
	 public List<Ads> listAll() {
	        return AdsRepository.findAll(Sort.by("id").ascending());
	    }
	 
	
		
	
}
