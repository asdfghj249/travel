package com.service.impl;

import com.NotFoundException;
import com.dao.TagMapper;
import com.pojo.Tag;
import com.pojo.TagExample;
import com.service.ITagService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl implements ITagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public List<Tag> getAllTags() {
        return tagMapper.selectByExample(null);
    }

    @Override
    public Tag getTagById(Long id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    public Tag getTagByName(String name) {
        TagExample example = new TagExample();
        example.createCriteria().andNameEqualTo(name);
        List<Tag> tags = tagMapper.selectByExample(example);
        return tags.size() > 0 ? tags.get(0) : null;
    }

    @Override
    public void saveTag(Tag tag) {
        tagMapper.insert(tag);
    }

    @Override
    public void updateTag(Tag tag) {
        Tag t = tagMapper.selectByPrimaryKey(tag.getId());
        if (t == null){
            throw  new NotFoundException("该标签不存在");
        }
        BeanUtils.copyProperties(tag,t);
        tagMapper.updateByPrimaryKey(t);
    }

    @Override
    public void deleteTag(Long id) {
        tagMapper.deleteByPrimaryKey(id);
    }
}
