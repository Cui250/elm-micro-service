package ynu.edu.business_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ynu.edu.business_service.mapper.BusinessMapper;
import ynu.edu.business_service.po.Business;
import ynu.edu.business_service.service.BusinessService;

import java.util.List;
@Service
public class BusinessServiceImpl implements BusinessService{

    @Autowired
    private BusinessMapper businessMapper;
    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        return businessMapper.listBusinessByOrderTypeId(orderTypeId);
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        return businessMapper.getBusinessById(businessId);
    }
}