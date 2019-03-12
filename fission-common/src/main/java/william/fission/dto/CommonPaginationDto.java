package william.fission.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * @Auther: ZhangShenao
 * @Date: 2018/7/23 13:31
 * @Description: 通用的分页Dto
 */
@Getter
@Setter
public class CommonPaginationDto<T> {
    private CommonPagination pagination;
    private List<T> data;


    @Getter
    @Setter
    public static class CommonPagination {
        private int offset;
        private int limit;
        private long total;
    }

    public static <T> CommonPaginationDto valueOf(int offset, int limit, long total) {
        CommonPaginationDto<T> paginationDto = new CommonPaginationDto<>();
        CommonPaginationDto.CommonPagination pagination = new CommonPaginationDto.CommonPagination();
        pagination.setLimit(limit);
        pagination.setOffset(offset);
        pagination.setTotal(total);
        paginationDto.setPagination(pagination);
        return paginationDto;
    }
}
