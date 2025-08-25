package Mapper;

import Domain.Organization;
import Domain.ShopExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrganization {
    boolean increaseOrganizaton(@Param("list") List<Organization> organizationsList);
}
