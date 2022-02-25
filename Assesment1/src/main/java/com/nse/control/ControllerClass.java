package com.nse.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nse.entity.PortfolioDemo;

import com.nse.entity.ShareDemo;
import com.nse.service.StockService;

@RestController
public class ControllerClass {

	@Autowired(required = true)
	StockService service;

	@RequestMapping("/makePortfolios")
	public ResponseEntity<PortfolioDemo> createPortfolio(@RequestBody PortfolioDemo p) {
		return new ResponseEntity<>(service.createPortfolio(p), HttpStatus.OK);
	}

	@RequestMapping("/makeShares")
	public ResponseEntity<ShareDemo> createShare(@RequestBody ShareDemo s) {
		return new ResponseEntity<>(service.createShare(s), HttpStatus.OK);
	}

	@RequestMapping("/buyShares/{shareId}/{portfolioId}")
	public boolean buyShare(@PathVariable Integer shareId, @PathVariable Integer portfolioId) {
		return service.buyShare(shareId, portfolioId);
	}

	@RequestMapping("/sellShares/{shareId}/{portfolioId}")
	public boolean sellShare(@PathVariable Integer shareId, @PathVariable Integer portfolioId) {
		return service.sellShare(shareId, portfolioId);
	}

	@RequestMapping("/displayPortfolios")
	public ResponseEntity<List<PortfolioDemo>> showPortfolio() {
		return new ResponseEntity<>(service.showPortfolio(), HttpStatus.OK);
	}
}
