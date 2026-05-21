package fan.fancy.iam.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.fancy.api.iam.pojo.bo.UserBO;
import fan.fancy.iam.pojo.dto.MenuDTO;
import fan.fancy.iam.pojo.dto.PermissionDTO;
import fan.fancy.iam.pojo.dto.RoleDTO;
import fan.fancy.iam.pojo.dto.UserDTO;
import fan.fancy.iam.pojo.entity.MenuDO;
import fan.fancy.iam.pojo.entity.PermissionDO;
import fan.fancy.iam.pojo.entity.RoleDO;
import fan.fancy.iam.pojo.entity.UserDO;
import fan.fancy.iam.pojo.vo.MenuVO;
import fan.fancy.iam.pojo.vo.PermissionVO;
import fan.fancy.iam.pojo.vo.RoleVO;
import fan.fancy.iam.pojo.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * 身份访问管理实体转换类.
 *
 * @author Fan
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IamConverter {

    UserVO convertUser(UserDO userDO);

    UserBO convertUserBO(UserDO userDO);

    UserDO convertUserBO(UserBO userBO);

    List<UserVO> convertUsers(List<UserDO> list);

    Page<UserVO> convertUsers(Page<UserDO> page);

    @Mapping(target = "birthday", source = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserDO convertUser(UserDTO userDTO);

    RoleVO convertRole(RoleDO roleDO);

    List<RoleVO> convertRoles(List<RoleDO> list);

    Page<RoleVO> convertRoles(Page<RoleDO> page);

    RoleDO convertRole(RoleDTO roleDTO);

    PermissionVO convertPermission(PermissionDO permissionDO);

    List<PermissionVO> convertPermissions(List<PermissionDO> list);

    Page<PermissionVO> convertPermissions(Page<PermissionDO> page);

    PermissionDO convertPermission(PermissionDTO permissionDTO);

    MenuVO convertMenu(MenuDO menuDO);

    List<MenuVO> convertMenus(List<MenuDO> list);

    Page<MenuVO> convertMenus(Page<MenuDO> page);

    MenuDO convertMenu(MenuDTO menuDTO);
}
