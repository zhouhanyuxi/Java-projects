package com.ncu.clothwholesale.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ncu.clothwholesale.pojo.Picture;
import com.ncu.clothwholesale.pojo.Product;
import com.ncu.clothwholesale.pojo.ProductModel;
import com.ncu.clothwholesale.pojo.SellPrice;
import com.ncu.clothwholesale.vo.ModelSaleInfo;
import com.ncu.clothwholesale.vo.ProductVO;

public interface ProductService {
	public String addProduct(ProductVO p)throws Exception;
	public boolean updateProduct(Product p)throws Exception;
	public Object listByCondition(Map<String, Object> args);
	public List<Product> findProductById(String productCode) throws Exception;
	public List<Product> findTProductById(String productCode) throws Exception;
	public List<ProductModel> findModelByProduct(String productCode)throws Exception;
	public Picture findPicByModel(String modelCode)throws Exception ;
	public String addModel(String productCode,String modelName,MultipartFile file,String path)throws Exception ;
	public Object listWithPicByCondition(Map<String, Object> args);
	public List<SellPrice> findPriceByProductCode(String productCode)throws Exception;
	public ModelSaleInfo findModelSaleInfoById(String modelCode)throws Exception;
	public boolean addPriceByProductCode(int lowerLimit, float price, String productCode)throws Exception;
	public boolean updateProductStateById(String productCode)throws Exception;
}
