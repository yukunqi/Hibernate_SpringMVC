package Upload.DAO;
import Entity.ExpertsInfo;
import java.util.List;

/**
 *
 */
public interface expertInfoDAO {

    /**
     * 查询老师信息列表的接口,
     * 返回老师的所有列表需要的数据
     * @return
     */
    List<ExpertsInfo> query_experts_list();
}
