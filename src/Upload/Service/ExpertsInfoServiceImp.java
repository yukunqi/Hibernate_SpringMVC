package Upload.Service;

import Entity.ExpertsInfo;
import Upload.DAO.expertInfoDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理咨询列表的service
 */
@Service
public class ExpertsInfoServiceImp implements ExpertInfoService {

    @Autowired
    private expertInfoDAO expertsInfoDAO;

    public List<ExpertsInfo> expertsInfoList(String type){
        return null;
    }

    /**
     * 按照咨询人数降序排序
     * @return
     */
    public void expertsInfoList1(){
        List<ExpertsInfo> list = expertsInfoDAO.query_experts_list();
        for (ExpertsInfo e:list){
            System.out.println(e.getConsult_number());
        }
    }

    /**
     * 按照好评率进行排序
     * @return
     */
    public  List<ExpertsInfo> expertsInfoList2(){
     return null;
    }
}
