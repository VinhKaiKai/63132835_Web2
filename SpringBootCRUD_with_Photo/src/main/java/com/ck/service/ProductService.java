package com.ck.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ck.model.Product;

public interface ProductService {

	
	
	
	// xây dựng chức năng SAVE
	Product saveProduct (Product product);
	// xây dựng chức năng lấy sản phẩm bởi id 
	Product getProductById (long id);
	
	
	//xây dựng chức năng DELETE
	void deleteProductById (long id);
	
	// xây dựng chức năng tất cả sản phẩm
	List<Product> getAllProduct(String keyword);
	
	// xây dựng chức năng phân trang cho các sản phẩm hiển thị 
	Page<Product> findPaginated (int pageNo, int pageSize, String sortField, String sortDirection);
	
}
