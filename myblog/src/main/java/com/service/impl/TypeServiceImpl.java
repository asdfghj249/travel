package com.service.impl;

import com.NotFoundException;
import com.dao.TypeMapper;
import com.pojo.Type;
import com.pojo.TypeExample;
import com.service.ITypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> getAllTypes() {
        return typeMapper.selectByExample(null);
    }

    @Override
    public Type getTypeById(Long id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Type getTypeByName(String name) {
        TypeExample example = new TypeExample();
        example.createCriteria().andNameEqualTo(name);
        List<Type> types = typeMapper.selectByExample(example);
        return types.size() > 0 ? types.get(0) : null;
    }

    @Override
    public void saveType(Type type) {
        typeMapper.insert(type);
    }

    @Override
    public void updateType(Type type) {
        Type t = typeMapper.selectByPrimaryKey(type.getId());
        if (t == null){
            throw new NotFoundException("该标签不存在");
        }
        BeanUtils.copyProperties(type,t);
        typeMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public void deleteType(Long id) {
        typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Type> getFiveType() {
        return typeMapper.getFiveType();
    }
}
