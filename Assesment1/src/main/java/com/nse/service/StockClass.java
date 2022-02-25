package com.nse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nse.entity.PortfolioDemo;
import com.nse.entity.ShareDemo;
import com.nse.Repository.PortfolioRepo;
import com.nse.Repository.ShareRepo;

@org.springframework.stereotype.Service
public class StockClass implements StockService {
	@Autowired
	private PortfolioRepo pRepo;

	@Autowired
	private ShareRepo sRepo;

	public PortfolioDemo createPortfolio(PortfolioDemo p) {//creates a repository for class Portfolio
		return pRepo.save(p);
	}

	public List<PortfolioDemo> showPortfolio() {
		return pRepo.findAll();
	}
	
	public ShareDemo createShare(ShareDemo s) {//creates a repository for class Share
		return sRepo.save(s);
	}
	
	public List<ShareDemo> showShare() {
		return sRepo.findAll();
	}

	public boolean buyShare(Integer shareId, Integer portfolioId) {
		PortfolioDemo p = pRepo.findById(portfolioId).get();
		ShareDemo s = sRepo.findById(shareId).get();
		p.setInvestment(p.getInvestment() + (s.getPrice()*s.getQuantity()));
		List<PortfolioDemo> plist = new ArrayList<>();
		plist.add(p);
		List<ShareDemo> slist = new ArrayList<>();
		slist.add(s);
		p.setShares(slist);
		s.setPortfolio(plist);
		pRepo.save(p);
		sRepo.save(s);
		return true;
	}

	public boolean sellShare(Integer shareId, Integer portfolioId) {
		PortfolioDemo p = pRepo.findById(portfolioId).get();
		ShareDemo s = sRepo.findById(shareId).get();
		p.setInvestment(p.getInvestment() - (s.getPrice()*s.getQuantity()));
		List<PortfolioDemo> plist = new ArrayList<>();
		plist.add(p);
		List<ShareDemo> slist = new ArrayList<>();
		slist.add(s);
		p.setShares(slist);
		s.setPortfolio(plist);
		pRepo.delete(p);
		sRepo.delete(s);
		return true;
	}

}
