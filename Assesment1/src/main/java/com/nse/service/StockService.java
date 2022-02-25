package com.nse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.nse.entity.PortfolioDemo;
import com.nse.entity.ShareDemo;

@org.springframework.stereotype.Service
public interface StockService {

	public PortfolioDemo createPortfolio(PortfolioDemo p);

	public List<PortfolioDemo> showPortfolio();

	public boolean buyShare(Integer shareId, Integer portfolioId);

	public boolean sellShare(Integer shareId, Integer portfolioId);

	public List<ShareDemo> showShare();

	public ShareDemo createShare(ShareDemo s);

}
