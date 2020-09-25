package com.ncu.clothwholesale.serviceImpl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.clothwholesale.mapper.PictureMapper;
import com.ncu.clothwholesale.mapper.ProductMapper;
import com.ncu.clothwholesale.mapper.ProductModelMapper;
import com.ncu.clothwholesale.mapper.SellPriceMapper;
import com.ncu.clothwholesale.pojo.Picture;
import com.ncu.clothwholesale.pojo.Product;
import com.ncu.clothwholesale.pojo.ProductExample;
import com.ncu.clothwholesale.pojo.ProductModel;
import com.ncu.clothwholesale.pojo.ProductModelExample;
import com.ncu.clothwholesale.pojo.SellPrice;
import com.ncu.clothwholesale.pojo.SellPriceExample;
import com.ncu.clothwholesale.service.ProductService;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.MyDataFormatUtil;
import com.ncu.clothwholesale.tool.ValidateUtils;
import com.ncu.clothwholesale.tool.ValidateUtils.DefaultPageInfoName;
import com.ncu.clothwholesale.vo.ModelSaleInfo;
import com.ncu.clothwholesale.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProductModelMapper modelMapper;
	@Autowired
	private PictureMapper pictureMapper;
	@Autowired
	private SellPriceMapper priceMapper;

	@Transactional(rollbackFor=Exception.class)
	@Override
	public String addProduct(ProductVO p) throws Exception {
		ProductExample example = new ProductExample();
		com.ncu.clothwholesale.pojo.ProductExample.Criteria criteria = example.createCriteria();
		criteria.andProductCodeLike("%"+p.getSupplierCode()+"%");

		int num = productMapper.countByExample(example);
		
		Product product = new Product();
		product.setOriginalName(p.getOriginalName());
		product.setProductCode(p.getSupplierCode()+"0000"+(num+1));
		product.setProductName(p.getProductName());
		product.setState("F");
		product.setWeight(Integer.parseInt(p.getWeight()));
		product.setWidth(Integer.parseInt(p.getWidth()));
		product.setThickness(p.getThickness());
		product.setIngredient(p.getIngredient());
		product.setOriginalPrice(0.0);
		product.setTypeTotal((short)0);
		
		if(productMapper.insertSelective(product)==1){
			ProductModel model = new ProductModel();
			model.setModelCode(product.getProductCode()+"000");
			model.setProductCode(product.getProductCode());
			model.setTotalNum(0);
			model.setModelName("");
			if(modelMapper.insert(model)==1)
				return product.getProductCode();
			else {
				throw new BusinessException("添加产品失败");
			}
		}else{
			throw new BusinessException("添加产品失败");
		}
		
	}

	@Override
	public boolean updateProduct(Product p) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object listByCondition(Map<String, Object> args) {
		
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = productMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	@Override
	public List<ProductModel> findModelByProduct(String productCode) throws Exception {
		ProductModelExample example = new ProductModelExample();
		com.ncu.clothwholesale.pojo.ProductModelExample.Criteria criteria = example.createCriteria();
		criteria.andProductCodeEqualTo(productCode);
		List<ProductModel> list = modelMapper.selectByExample(example);
		if(list ==null || list.size()<1)
			throw new BusinessException("未找到产品型号！");
		else
			return list;
	}

	@Override
	public List<Product> findProductById(String productCode) throws Exception{
		ProductExample example = new ProductExample();
		com.ncu.clothwholesale.pojo.ProductExample.Criteria criteria = example.createCriteria();
		criteria.andProductCodeLike("%"+productCode+"%");
		List<Product> list = productMapper.selectByExample(example);
		if(list ==null || list.size()<1)
			throw new BusinessException("未找到产品！");
		else
			return list;
	}
	
	@Override
	public List<Product> findTProductById(String productCode) throws Exception{
		ProductExample example = new ProductExample();
		com.ncu.clothwholesale.pojo.ProductExample.Criteria criteria = example.createCriteria();
		criteria.andProductCodeLike("%"+productCode+"%");
		criteria.andStateEqualTo("T");
		List<Product> list = productMapper.selectByExample(example);
		if(list ==null || list.size()<1)
			throw new BusinessException("未找到产品！");
		else
			return list;
	}
	
	@Override
	public Picture findPicByModel(String modelCode) throws Exception {
		Picture p = pictureMapper.selectByPrimaryKey(modelCode+"-1.jpg");
		if(p==null){
			throw new BusinessException("未找到图片！");
		}else
			return p;
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public String addModel(String productCode,String modelName,MultipartFile file,String path) throws Exception {
		ProductModelExample example = new ProductModelExample();
		com.ncu.clothwholesale.pojo.ProductModelExample.Criteria criteria = example.createCriteria();
		criteria.andProductCodeEqualTo(productCode);
		int num = modelMapper.countByExample(example);
		ProductModel m = new ProductModel();
		m.setModelName(modelName);
		m.setTotalNum(0);
		m.setProductCode(productCode);
		m.setModelCode(productCode+MyDataFormatUtil.unitFormatHundred(num));
		
		File targetFile = null;
		if(file!=null){
			String filename = file.getOriginalFilename();
			String prefix = filename.substring(filename.lastIndexOf(".")+1);
			String newName = m.getModelCode()+"-1."+prefix;
			//path+="//"+newName;
			System.out.println(path);
			targetFile = new File(path,newName);
			if(!targetFile.exists()){
				targetFile.mkdirs();
			}
			file.transferTo(targetFile);
		}else{
			throw new BusinessException("请选择文件！");
		}
		
		if(modelMapper.insert(m)==1){
			Product p = new Product();
			p.setTypeTotal((short) (num));
			p.setProductCode(productCode);
			productMapper.updateByPrimaryKeySelective(p);
			
			Picture pic = new Picture();
			pic.setFilename(targetFile.getName());
			pic.setModelCode(m.getModelCode());
			pic.setPictureIndex((short)(num));
			pictureMapper.insertSelective(pic);
			
			return targetFile.getName();
		}else{
			throw new BusinessException("插入失败！");
		}
		
	}

	@Override
	public Object listWithPicByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = productMapper.listWithPicByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	@Override
	public List<SellPrice> findPriceByProductCode(String productCode) throws Exception {
		SellPriceExample example = new SellPriceExample();
		com.ncu.clothwholesale.pojo.SellPriceExample.Criteria criteria = example.createCriteria();
		criteria.andProductCodeEqualTo(productCode);
		example.setOrderByClause("lowerLimit");
		
		List<SellPrice> list = priceMapper.selectByExample(example);
		if(list.size()>0){
			return list;
		}else{
			throw new BusinessException("未找到价格");
		}
	}

	@Override
	public ModelSaleInfo findModelSaleInfoById(String modelCode) throws Exception{
		ModelSaleInfo info = modelMapper.findModelSaleInfoById(modelCode);
		if(info==null){
			throw new BusinessException("未找到该产品型号的相关信息");
		}
		return info;
	}

	@Override
	public boolean addPriceByProductCode(int lowerLimit, float price,String productCode)throws Exception {
		SellPrice sellPrice = new SellPrice();
		sellPrice.setLowerLimit(lowerLimit);
		sellPrice.setPrice(price);
		sellPrice.setProductCode(productCode);
		//查询已有价格
		SellPriceExample example = new SellPriceExample();
		com.ncu.clothwholesale.pojo.SellPriceExample.Criteria criteria = example.createCriteria();
		criteria.andProductCodeEqualTo(productCode);
		List<SellPrice> list = priceMapper.selectByExample(example);
		int num = 0;
		if(list!=null){
			num = list.size();
		}
		sellPrice.setSellPriceCode(productCode+(num+1));
		
		if(priceMapper.insertSelective(sellPrice)==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProductStateById(String productCode) throws Exception {
		SellPriceExample example = new SellPriceExample();
		com.ncu.clothwholesale.pojo.SellPriceExample.Criteria criteria = example.createCriteria();
		criteria.andProductCodeEqualTo(productCode);
		List<SellPrice> list = priceMapper.selectByExample(example);
		if(list.size()==0){
			throw new BusinessException("未标价，不可上架");
		}
		Product product = productMapper.selectByPrimaryKey(productCode);
		if(product!=null){
			if(product.getState().equals("T")) product.setState("F");
			else product.setState("T");
			if(productMapper.updateByPrimaryKeySelective(product)==1)
				return true;
		}
		return false;
	}
 

}
