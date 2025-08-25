package Mapper;


import Domain.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IShopMapper {
    Boolean increaseShop(@Param("list") List<Shop> ShopList);

    Boolean existsByYqsOrgCodeAndTenant(@Param("yqsOrgCode") String yqsOrgCode,
                                        @Param("tenantCode") String tenantCode);
}
