package com.prescription.memory.service;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjProgrammePo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.ProgrammeVo;
import com.prescription.memory.error.BusinessException;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
public interface ZyyjProgrammeService extends IService<ZyyjProgrammePo> {
    public Page<ProgrammeVo> getProgrammeByPage(String name);

    public List<ZyyjProgrammePo> getAll();

    public boolean insertProgramme(ZyyjProgrammePo programmePo);

    public boolean updateProgramme(ZyyjProgrammePo programmePo) throws BusinessException;

    public boolean deleteProgrammeById(Integer[] programmeIds) throws BusinessException;
}
