package ynu.edu.business_service.service;

import ynu.edu.business_service.po.Business;

import java.util.List;
public interface BusinessService {
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);
    public Business getBusinessById(Integer businessId);
}