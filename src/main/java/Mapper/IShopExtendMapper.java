package Mapper;

import DTO.ShopExcelDTO;
import Domain.ShopExtend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface IShopExtendMapper {
    Boolean increaseShopExtend(@Param("list") List<ShopExtend> shopExtendsList);

}
