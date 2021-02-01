package com.catalogy.moviectalogservice.resources;

import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogy.moviectalogservice.models.CatalogItem;

@RestController
public class MovieCatalogController {

	@RequestMapping("/catalog/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		return Collections.singletonList(
				new CatalogItem("Stars", "TTTT", 3)
				);
	}

}


