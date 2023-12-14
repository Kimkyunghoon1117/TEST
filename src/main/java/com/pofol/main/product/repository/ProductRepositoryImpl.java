package com.pofol.main.product.repository;

import com.pofol.main.product.domain.ProductDto;
import com.pofol.main.product.domain.ProductImageDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final String namespace = "ecoeats.productMapper.";
    private final SqlSession session;

    @Autowired
    public ProductRepositoryImpl(SqlSession session) {
        this.session = session;
    }

    // 상품 등록(INSERT)
    @Override
    public void insert(ProductDto productDto) throws Exception {
        session.insert(namespace + "insert", productDto);
    }

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    // 상품 이미지 등록(INSERT)
    @Override
    public void insertImage(ProductImageDto productImageDto) throws Exception {
        session.insert(namespace + "insertImage", productImageDto);
    }
}
